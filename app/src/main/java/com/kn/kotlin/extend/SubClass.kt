package com.kn.kotlin.extend

import android.util.Log

/**
 * Created by MaZhihua on 2017/11/3.
 */
class SubClass : BaseClass("KNothing",1.80F) {
    val TAGSUB = SubClass::class.java.simpleName
    fun subMethodOne(age:Int){
        Log.d(TAGSUB,"subMethodOne age = $age")
    }
}