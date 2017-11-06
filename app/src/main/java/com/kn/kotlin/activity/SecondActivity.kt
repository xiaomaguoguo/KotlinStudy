package com.kn.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.kn.kotlin.R
import kotlinx.android.synthetic.main.second_activity.*

/**
 * Created by MaZhihua on 2017/11/2.
 */
class SecondActivity : AppCompatActivity(),View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.second_activity)
        val extra = intent.extras.getString("extra")
        if(extra != null){
            tv.text = extra
        }
    }

    override fun onClick(v: View?) {

    }

    override fun onDestroy() {
        super.onDestroy()
    }
}