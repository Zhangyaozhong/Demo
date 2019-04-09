package com.wd.demo.mvp.presenter

import com.wd.demo.bean.BannerBean
import com.wd.demo.bean.InformationBean
import com.wd.demo.mvp.ModelCallback
import com.wd.demo.mvp.contract.InformationContract
import com.wd.demo.mvp.model.InformationModel

/**
 * @name Demo
 * @class name：com.wd.demo.mvp.presenter
 * @author 张耀中
 * @time 2019/4/9 21:00
 */
class InformationPresenter : InformationContract.InformationPresenter() {
    lateinit var iInformationView: InformationContract.IInformationView
    lateinit var informationModel: InformationModel
    fun attach(iInformationView: InformationContract.IInformationView) {
        this.iInformationView = iInformationView
        informationModel = InformationModel()
    }

    override fun information(params: HashMap<String, String>) {
        informationModel.information(params, object : ModelCallback<InformationBean> {
            override fun success(t: InformationBean) {
                iInformationView.informationSuccess(t)
            }

            override fun failure(msg: String) {
                iInformationView.error(msg)
            }

        })
    }

    override fun banner() {
        informationModel.banner(object : ModelCallback<BannerBean> {
            override fun success(t: BannerBean) {
                iInformationView.bannerSuccess(t)
            }

            override fun failure(msg: String) {

                iInformationView.error(msg)
            }

        })
    }

    /*  fun attach() {


      }*/
}