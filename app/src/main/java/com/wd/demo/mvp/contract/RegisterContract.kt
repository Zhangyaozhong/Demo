package com.wd.demo.mvp.contract

import com.wd.demo.bean.RegisterBean
import com.wd.demo.mvp.ModelCallback

/**
 * @name Demo
 * @class name：com.wd.demo.mvp.contract
 * @author 张耀中
 * @time 2019/4/8 15:31
 */
interface RegisterContract {
    open abstract class RegisterPresenter {
        abstract fun reg(params: HashMap<String, String>)
    }

    interface IRegisterModel {
        fun reg(params: HashMap<String, String>, modelCallback: ModelCallback<RegisterBean>)
    }

    interface IRegisterView {
        fun regSuccess(regBean: RegisterBean)
        fun error(msg: String)
    }
}