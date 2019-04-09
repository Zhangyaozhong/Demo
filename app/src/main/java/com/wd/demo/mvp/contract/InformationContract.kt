package com.wd.demo.mvp.contract

import com.wd.demo.bean.BannerBean
import com.wd.demo.bean.InformationBean
import com.wd.demo.mvp.ModelCallback

/**
 * @name Demo
 * @class name：com.wd.demo.mvp.contract
 * @author 张耀中
 * @time 2019/4/8 15:31
 */
interface InformationContract {
    open abstract class InformationPresenter {
        abstract fun information(params: HashMap<String, String>)
        abstract fun banner()
    }

    interface IInformationModel {
        fun information(params: HashMap<String, String>, modelCallback: ModelCallback<InformationBean>)
        fun banner(modelCallback: ModelCallback<BannerBean>)
    }

    interface IInformationView {
        fun informationSuccess(informationBean: InformationBean)
        fun bannerSuccess(bannerBean: BannerBean)
        fun error(msg: String)
    }
}