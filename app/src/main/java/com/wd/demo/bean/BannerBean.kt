package com.wd.demo.bean

/**
 * @name Demo
 * @class name：com.wd.demo.bean
 * @author 张耀中
 * @time 2019/4/9 9:32
 */
data class BannerBean(
    val message: String,
    val result: List<Result>,
    val status: String
) {
    data class Result(
        val imageUrl: String,
        val jumpUrl: String,
        val rank: Int,
        val title: String
    )
}