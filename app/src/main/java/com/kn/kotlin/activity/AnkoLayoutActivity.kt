package com.kn.kotlin.activity

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by MaZhihua on 2017/11/6.
 */
class AnkoLayoutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //方式一
//        initLayout()

        //方式二
        AnkoLayoutDSL().setContentView(this)

    }

    private fun initLayout() {
        linearLayout {
            lparams{
                width = matchParent
                height = matchParent
                orientation = LinearLayout.VERTICAL
                gravity = Gravity.CENTER
                padding = dip(16)
            }

            editText {
                width = matchParent
                width = matchParent
                height = dip(50)
            }


            editText {
                width = matchParent
                height = dip(50)
            }

            button("Fucking") {
                width = matchParent
                height = dip(60)

                onClick {
                    toast("点击了按钮")
                }
            }


        }
    }

}