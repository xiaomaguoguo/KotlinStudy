package com.kn.kotlin.extend

import android.util.Log

/**
 * Created by MaZhihua on 2017/11/3.
 */
open class BaseClass constructor(var name:String,var height:Float) {

    val TAG = BaseClass::class.java.simpleName

    fun baseMethodOne(name: String){
        Log.d(TAG,"baseMethodOne $name")
    }

    fun baseMethodTwo(height: Float){
        Log.d(TAG,"baseMethodTwo $height")
    }

}