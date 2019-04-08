package com.wd.demo.mvp.model

import android.annotation.SuppressLint
import com.wd.demo.api.ApiService
import com.wd.demo.bean.LoginBean
import com.wd.demo.mvp.ModelCallback
import com.wd.demo.mvp.contract.LoginContract
import com.wd.demo.net.NetScheduler
import com.wd.demo.net.RetrofitManager
import io.reactivex.Observer
import io.reactivex.functions.Consumer

/**
 * @name Demo
 * @class name：com.wd.demo.mvp.contract
 * @author 张耀中
 * @time 2019/4/8 16:25
 */
class LoginModel : LoginContract.ILoginModel {
    @SuppressLint("CheckResult")
    override fun login(params: HashMap<String, String>, modelCallback: ModelCallback<LoginBean>) {
        RetrofitManager.instance.createSerivce(ApiService::class.java)
                .login(params)
                .compose(NetScheduler().compose())
                .subscribe(Consumer {
                    modelCallback.success(it)
                })
    }

}