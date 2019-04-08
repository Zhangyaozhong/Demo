package com.wd.demo.bean

import android.os.Parcel
import android.os.Parcelable

/**
 * @name Demo
 * @class name：com.wd.demo.bean
 * @author 张耀中
 * @time 2019/4/8 20:02
 */
data class RegisterBean(val message: String,
                        val status: String) : Parcelable {
    constructor(parcel: Parcel) : this(
            parcel.readString(),
            parcel.readString()) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(message)
        parcel.writeString(status)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<RegisterBean> {
        override fun createFromParcel(parcel: Parcel): RegisterBean {
            return RegisterBean(parcel)
        }

        override fun newArray(size: Int): Array<RegisterBean?> {
            return arrayOfNulls(size)
        }
    }

}