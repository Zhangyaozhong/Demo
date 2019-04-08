package com.wd.demo

import android.app.Application

/**
 * @name Demo
 * @class name：com.wd.demo
 * @author 张耀中
 * @time 2019/4/8 14:52
 */
class MyApp : Application() {
    override fun onCreate() {
        super.onCreate()
        val initializeService = InitializeService()
        initializeService.start(this)
    }
}