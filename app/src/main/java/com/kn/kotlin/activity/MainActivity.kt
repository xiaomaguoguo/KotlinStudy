package com.kn.kotlin.activity

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import com.kn.kotlin.R
import com.kn.kotlin.entity.Student
import kotlinx.android.synthetic.main.main_activity.*

/**
 * Created by MaZhihua on 2017/11/2.
 * Kotlin学习主页面
 */
class MainActivity : AppCompatActivity(),View.OnClickListener {

    val TAG:String = MainActivity::class.java.simpleName

    var string_array:Array<String> = arrayOf("for循环","类对象Obj","页面跳转")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        initView()
    }

    fun initView(){
        if(string_array!!.size != 0){
            for(i in string_array.indices){
                var text = string_array[i];
                val btn = Button(this)
                btn.text = text;
                btn.setOnClickListener(this)
                btn.id = i
                btnContainer.addView(btn)
            }
        }
    }

    override fun onClick(v: View?) {
        val id = v?.id
        when(id){
            0 -> forRecycle()
            1 -> kotlinObj()
            2 -> openPage()
        }
    }

    /**
     * for循环
     */
    fun forRecycle(){

        // type 1
        for(i in 5 until 10){
            Log.d(TAG,"左闭右开循环，包括5，不包括10 ,i = $i")
        }

        // type 2
        for(i in 10..20 step 2){
            Log.d(TAG,"递增循环，每次递增2 ,i = $i")
        }

        // type 3
        for(i in 10 downTo 5){
            Log.d(TAG,"递减循环，每次递减5 ,i = $i")
        }

    }

    /**
     * 类对象s
     */
    fun kotlinObj(){
        val student = Student("KNothing","哈佛",1.80F,100)
        Log.d(TAG,"obj msg = $student")
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    /**
     * 跳转页面
     */
    fun openPage(){
        val intent = Intent()
        intent.setClass(this,SecondActivity::class.java)
        startActivity(intent)
    }
}
