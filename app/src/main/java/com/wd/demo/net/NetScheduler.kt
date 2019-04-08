package com.wd.demo.net

import io.reactivex.ObservableTransformer
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * @name Demo
 * @class name：com.wd.demo.net
 * @author 张耀中
 * @time 2019/4/8 14:34
 */
class NetScheduler {
    fun <T> compose(): ObservableTransformer<T, T> {
        return ObservableTransformer { observable ->
            observable.subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
        }
    }
}