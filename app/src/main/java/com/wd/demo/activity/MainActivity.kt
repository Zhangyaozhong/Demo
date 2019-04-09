package com.wd.demo.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.blankj.utilcode.util.SPUtils
import com.blankj.utilcode.util.ToastUtils
import com.wd.demo.R
import com.wd.demo.bean.LoginBean
import com.wd.demo.mvp.contract.LoginContract
import com.wd.demo.mvp.presenter.LoginPresenter
import com.wd.demo.utils.RsaCoder
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener, LoginContract.ILoginView {
    var loginPresenter = LoginPresenter()
    override fun loginSuccess(loginBean: LoginBean) {
        ToastUtils.showShort(loginBean.message)
        if (loginBean.status == "0000") {
//            登录成功后将userId、sessionId存到sp
            SPUtils.getInstance().put("userId", loginBean.result.userId);
            SPUtils.getInstance().put("sessionId", loginBean.result.sessionId);
            var intent = Intent()
            startActivity(intent.setClass(this, HomeActivity::class.java))
        }
    }

    override fun error(msg: String) {
        ToastUtils.showShort(msg)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.login_btn -> login()
            R.id.fast_reg -> {
                val intent = Intent(this, RegisterActivity::class.java)
                startActivity(intent)
            }

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        login_btn.setOnClickListener(this)
        fast_reg.setOnClickListener(this)
        loginPresenter.attach(this)

    }

    fun login() {

        //        获取账号密码
        val phone = phone.text.toString().trim()
        val pwd = pwd.text.toString().trim()
//        密码加密
        val encryptByPublicKey = RsaCoder.encryptByPublicKey(pwd)

        var parmas = HashMap<String, String>()
        parmas.put("phone", phone)
        parmas.put("pwd", encryptByPublicKey)
        loginPresenter.login(parmas)

    }

    override fun onDestroy() {
        super.onDestroy()
        loginPresenter.detach()
    }
}

