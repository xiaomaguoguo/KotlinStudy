package com.kn.kotlin.`interface`

import android.util.Log

/**
 * Created by MaZhihua on 2017/11/3.
 */
class IServiceImpl(override var name: String, override var height: Float) :IServiceStub,IService {

    val TAG = IServiceImpl::class.java.simpleName

    override fun methodOne() {
        Log.d(TAG,"methodOne Invoke")
    }

    override fun methodTwo() {
        Log.d(TAG,"methodTwo Invoke")
    }
}