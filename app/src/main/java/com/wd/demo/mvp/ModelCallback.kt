package com.wd.demo.mvp

/**
 * @name Demo
 * @class name：com.wd.demo.mvp
 * @author 张耀中
 * @time 2019/4/8 16:27
 */
interface ModelCallback<T> {
    fun success(t: T)
    fun failure(msg: String)
}