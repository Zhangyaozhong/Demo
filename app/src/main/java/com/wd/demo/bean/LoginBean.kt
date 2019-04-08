package com.wd.demo.bean

/**
 * @name Demo
 * @class name：com.wd.demo.bean
 * @author 张耀中
 * @time 2019/4/8 15:05
 */
data class LoginBean(
    val message: String,
    val result: Result,
    val status: String
) {
    data class Result(
        val headPic: String,
        val nickName: String,
        val phone: String,
        val pwd: String,
        val sessionId: String,
        val userId: Int,
        val userName: String,
        val whetherFaceId: Int,
        val whetherVip: Int
    )
}