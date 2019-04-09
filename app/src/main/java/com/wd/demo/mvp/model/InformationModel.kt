package com.wd.demo.mvp.model

import android.annotation.SuppressLint
import com.wd.demo.api.ApiService
import com.wd.demo.bean.BannerBean
import com.wd.demo.bean.InformationBean
import com.wd.demo.mvp.ModelCallback
import com.wd.demo.mvp.contract.InformationContract
import com.wd.demo.net.NetScheduler
import com.wd.demo.net.RetrofitManager

/**
 * @name Demo
 * @class name：com.wd.demo.mvp.contract
 * @author 张耀中
 * @time 2019/4/8 16:25
 */
class InformationModel : InformationContract.IInformationModel {
    @SuppressLint("CheckResult")
    override fun information(params: HashMap<String, String>, modelCallback: ModelCallback<InformationBean>) {
        RetrofitManager.instance.createSerivce(ApiService::class.java)
                .information(params)
                .compose(NetScheduler().compose())
                .subscribe {
                    modelCallback.success(it)
                }
    }

    @SuppressLint("CheckResult")
    override fun banner(modelCallback: ModelCallback<BannerBean>) {
        RetrofitManager.instance.createSerivce(ApiService::class.java)
                .banner()
                .compose(NetScheduler().compose())
                .subscribe {
                    modelCallback.success(it)
                }
    }

}