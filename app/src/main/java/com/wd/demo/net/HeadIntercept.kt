package com.wd.demo.net

import com.blankj.utilcode.util.SPUtils
import okhttp3.Interceptor
import okhttp3.Response

/**
 * @name Demo
 * @class name：com.wd.demo.net
 * @author 张耀中
 * @time 2019/4/9 20:50
 */
class HeadIntercept : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val build = chain.request().newBuilder()
                .addHeader("userId", SPUtils.getInstance().getString("userId"))
                .addHeader("sessionId", SPUtils.getInstance().getString("sessionId"))
                .build()
        return chain.proceed(build)
    }
}