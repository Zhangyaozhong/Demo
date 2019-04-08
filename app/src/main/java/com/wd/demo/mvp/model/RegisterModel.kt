package com.wd.demo.mvp.model

import android.annotation.SuppressLint
import com.wd.demo.api.ApiService
import com.wd.demo.bean.RegisterBean
import com.wd.demo.mvp.ModelCallback
import com.wd.demo.mvp.contract.RegisterContract
import com.wd.demo.net.NetScheduler
import com.wd.demo.net.RetrofitManager
import io.reactivex.functions.Consumer

/**
 * @name Demo
 * @class name：com.wd.demo.mvp.model
 * @author 张耀中
 * @time 2019/4/8 20:08
 */
class RegisterModel : RegisterContract.IRegisterModel {
    @SuppressLint("CheckResult")
    override fun reg(params: HashMap<String, String>, modelCallback: ModelCallback<RegisterBean>) {
        RetrofitManager.instance.createSerivce(ApiService::class.java)
                .reg(params)
                .compose(NetScheduler().compose())
                .subscribe(Consumer(modelCallback::success))
    }

}