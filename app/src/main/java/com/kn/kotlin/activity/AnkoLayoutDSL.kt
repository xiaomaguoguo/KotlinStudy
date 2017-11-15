package com.kn.kotlin.activity

import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by MaZhihua on 2017/11/6.
 */
class AnkoLayoutDSL : AnkoComponent<AnkoLayoutActivity> {

    override fun createView(ui: AnkoContext<AnkoLayoutActivity>): View {
        return with(ui){
            linearLayout {
                lparams{
                    width = matchParent
                    height = matchParent
                    orientation = LinearLayout.VERTICAL
                    gravity = Gravity.CENTER
                    padding = dip(16)
                }


                var editText = editText {
                    width = matchParent
                    height = dip(50)
                }

                var editText2 = editText {
                    width = matchParent
                    height = dip(50)
                }

                var loginBtn = button("Fucking") {
                    width = matchParent
                    height = dip(60)

                    onClick {
                        toast("点击了按钮")
                    }
                }


            }
        };
    }
}