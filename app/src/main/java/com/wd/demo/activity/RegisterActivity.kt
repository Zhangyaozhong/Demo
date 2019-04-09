package com.wd.demo.activity

import android.app.Activity
import android.os.Bundle
import com.blankj.utilcode.util.ToastUtils
import com.wd.demo.R
import com.wd.demo.bean.RegisterBean
import com.wd.demo.mvp.contract.RegisterContract
import com.wd.demo.mvp.presenter.RegisterPresenter
import com.wd.demo.utils.RsaCoder
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : Activity(), RegisterContract.IRegisterView {
    override fun regSuccess(regBean: RegisterBean) {
        ToastUtils.showShort(regBean.message)
    }

    override fun error(msg: String) {
        ToastUtils.showShort(msg)
    }

    var registerPresenter = RegisterPresenter()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        registerPresenter.attach(this)
        reg_btn.setOnClickListener {
            val nickName = nick_name.text.toString().trim()
            val phone = reg_phone.text.toString().trim()
            val pwd = reg_pwd.text.toString().trim()
            val encryptByPublicKey = RsaCoder.encryptByPublicKey(pwd)

            var params = HashMap<String, String>()
            params.put("nickName", nickName)
            params.put("phone", phone)
            params.put("pwd", encryptByPublicKey)
            registerPresenter.reg(params)
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        registerPresenter.detach()
    }
}
