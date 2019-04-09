package com.wd.demo.api

import com.wd.demo.api.MyApi.BANNER_URL
import com.wd.demo.api.MyApi.INFORMATION_URL
import com.wd.demo.bean.BannerBean
import com.wd.demo.bean.InformationBean
import com.wd.demo.bean.LoginBean
import com.wd.demo.bean.RegisterBean
import io.reactivex.Observable
import retrofit2.http.*

/**
 * @name Demo
 * @class name：com.wd.demo.api
 * @author 张耀中
 * @time 2019/4/8 16:32
 */
interface ApiService {
    /**
     * 登录
     */
    @POST(MyApi.LOGIN_URL)
    @FormUrlEncoded
    fun login(@FieldMap params: HashMap<String, String>): Observable<LoginBean>

    /**
     * 注册
     */
    @POST(MyApi.REGISTER_URL)
    @FormUrlEncoded
    fun reg(@FieldMap params: HashMap<String, String>): Observable<RegisterBean>

    /**
     * Banner展示
     */
    @GET(BANNER_URL)
    fun banner(): Observable<BannerBean>

    @GET(INFORMATION_URL)
    fun information(@QueryMap parmas: HashMap<String, String>): Observable<InformationBean>
}