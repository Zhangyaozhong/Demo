package com.wd.demo

import android.app.IntentService
import android.content.Context
import android.content.Intent
import com.facebook.drawee.backends.pipeline.Fresco

/**
 * @name Demo
 * @class name：com.wd.demo
 * @author 张耀中
 * @time 2019/4/8 14:46
 */
class InitializeService : IntentService {
    constructor() : super("") {
    }

    override fun onCreate() {
        super.onCreate()

    }
    override fun onHandleIntent(intent: Intent?) {
        Fresco.initialize(application)
    }

    fun start(context: Context) {
        var intent = Intent(context, InitializeService::class.java)
        context.startService(intent)
    }
}