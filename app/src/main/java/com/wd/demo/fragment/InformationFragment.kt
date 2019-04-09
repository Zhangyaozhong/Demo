package com.wd.demo.fragment


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.wd.demo.R
import com.wd.demo.bean.BannerBean
import com.wd.demo.bean.InformationBean
import com.wd.demo.mvp.contract.InformationContract
import com.wd.demo.mvp.presenter.InformationPresenter

class InformationFragment : Fragment(), InformationContract.IInformationView {
    override fun informationSuccess(informationBean: InformationBean) {
        val result = informationBean.result
        for (resultBean in result) {
            println(resultBean.collection)
        }
    }

    override fun bannerSuccess(bannerBean: BannerBean) {
        for (result in bannerBean.result) {
            println(result.title)
        }
    }

    override fun error(msg: String) {
    }

    var informationPresenter = InformationPresenter()
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_information, container, false)
        initView()
        initData()
        return view
    }

    private fun initData() {
        informationPresenter.attach(this)
        informationPresenter.banner()
        var params = HashMap<String, String>()
        params.put("page", "1")
        params.put("count", "10")
        informationPresenter.information(params)
    }

    private fun initView() {
        /* refreshLayout.setOnRefreshListener {
             //            TODO()加载数据
             it.finishRefresh()  //刷新完成
         }
         refreshLayout.setOnLoadMoreListener {
             it.finishLoadMore()//加载完成
             it.finishLoadMoreWithNoMoreData()//全部加载完成,没有数据了调用此方法
         }*/
    }

}
