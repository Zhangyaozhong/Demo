package com.wd.demo.mvp.contract

import com.wd.demo.bean.LoginBean
import com.wd.demo.mvp.ModelCallback

/**
 * @name Demo
 * @class name：com.wd.demo.mvp.contract
 * @author 张耀中
 * @time 2019/4/8 15:31
 */
interface LoginContract {
    open abstract class LoginPresenter {
        abstract fun login(params: HashMap<String, String>)
    }

    interface ILoginModel {
        fun login(params: HashMap<String, String>, modelCallback: ModelCallback<LoginBean>)
    }

    interface ILoginView {
        fun loginSuccess(loginBean: LoginBean)
        fun error(msg: String)
    }
}