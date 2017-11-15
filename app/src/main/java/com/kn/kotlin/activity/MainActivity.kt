package com.kn.kotlin.activity

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Message
import android.support.annotation.IntegerRes
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.kn.kotlin.R
import com.kn.kotlin.`interface`.IService
import com.kn.kotlin.`interface`.IServiceImpl
import com.kn.kotlin.entity.Student
import com.kn.kotlin.extend.BaseClass
import com.kn.kotlin.extend.SubClass
import kotlinx.android.synthetic.main.main_activity.*
import kotlinx.coroutines.experimental.*
import org.jetbrains.anko.*
import java.sql.Ref
import java.util.concurrent.TimeUnit
import kotlin.properties.Delegates
import kotlinx.coroutines.experimental.android.UI
import org.jetbrains.anko.coroutines.experimental.asReference
import org.w3c.dom.Text
import kotlin.system.measureNanoTime
import kotlin.system.measureTimeMillis

/**
 * Created by MaZhihua on 2017/11/2.
 * Kotlin学习主页面
 */
class MainActivity : AppCompatActivity(),View.OnClickListener,AnkoLogger {

    val TAG:String = MainActivity::class.java.simpleName

    var string_array:Array<String> = arrayOf("for循环"
            ,"类对象Obj","页面跳转","三元运算","有返回值的函数","ArrayList"
            ,"接口/实现类","类继承","Object学习","Anko学习","写跨应用SP","AnkoLogger","协程学习","测试代码执行时间","快速调用","弱引用")

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
            3 -> threeComput()
            4 -> Log.d(TAG,containReturnResult("KNothing").toString())
            5 -> arrayList()
            6 -> interfaceImpl()
            7 -> classExtend()
            8 -> objectStudy()
            9 -> ankoLayout()
            10 -> writeGlobalSP()
            11 -> ankoLogger()
            12 -> kotlinCoroutine()
            13 -> measureTime();
            14 -> quickInvoke();
            15 -> weakReference();
            else -> Log.d(TAG,"when 没有匹配到时走这里")
        }
    }

    private fun ankoLogger() {
        debug { "Fucking" }
        info { "Fuck info" }
    }

    private fun weakReference(){
        val ref = asReference()
        startActivity<SecondActivity>("extra" to "This is first value")
        startActivity(intentFor<SecondActivity>("extra" to "This is second value").singleTop())
        val handler  = object : Handler(){
            override fun handleMessage(msg: Message?) {
                super.handleMessage(msg)
            }
        }
    }

    private fun quickInvoke(){
        makeCall("15210035012")
        sendSMS("15210035012")
        browse("www.baidu.com")
        share("shareText","这是分享的主题")
        email("mzh3344258@163.com","这是邮件主题")
    }

    /**
     * for循环
     */
    private fun forRecycle(){

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
    private fun kotlinObj(){
        val student = Student("KNothing","哈佛",1.80F,100)
        val copy2 = student.copy("KNFuck","家里蹲")
        Log.d(TAG,"obj msg = ${student}")
        Log.d(TAG,"obj2 msg = ${copy2}")
    }

    /**
     * 跳转页面
     */
    private fun openPage(){
        val intent = Intent()
        intent.setClass(this,SecondActivity::class.java)
        intent.putExtra("extra","这是传递过来的值")
        startActivity(intent)
    }

    /**
     * 三目运算
     */
    private fun threeComput() {
        val flag:Boolean = false
        var result:String? = null
        result = if (flag) "正确" else "错误"
        Log.d(TAG,result!!)
    }

    /**
     * 带参数带返回值函数测试
     */
    private fun containReturnResult(params:String): Boolean{
        return if (params.startsWith("KN"))true else false
    }

    /**
     * arrayList使用
     */
    private fun arrayList(){
        val array:ArrayList<String> = arrayListOf<String>()
        val array2 = arrayListOf<String>()
        array.add("a")
        array.add("b")
        array2.add("c")
        array2.add("d")

        val mapOf = mapOf<String,Int>()
        val mutableMapOf = mutableMapOf<String,Int>()
        val map = hashMapOf<Int,String>()
        map.put(0,"Zero")
        map.put(1,"One")
        map.put(2,"Two")

        var multable = mutableListOf<String>()
        multable.add("K")
        multable.add("N")
        multable.add("O")
    }

    /**
     * 接口及实现类学习
     */
    private fun interfaceImpl(){
        val service = IServiceImpl("KNohting",1.80f)
        service.methodOne()
        service.methodTwo()
    }

    /**
     * 类继承学习
     */
    private fun classExtend(){
        var baseClass = SubClass()
        baseClass.baseMethodOne("Fuck")
        baseClass.baseMethodTwo(1.90F)
        baseClass.subMethodOne(28)
    }

    /**
     * When的高级用法
     */
    private fun hasPrefix(x: Any) = when(x) {
        is String -> x.startsWith("prefix")
        else -> false
    }

    private fun labelUsed(){
        loop@ for (i in 1..100) {
            for (j in 1..100) {
                if (1 > 0) break@loop
            }
        }
    }

    sealed class FuckSecirity(){

    }

    inner class InnerClass(){
        val a = TAG // inner标识符可以让内部类访问外部类成员
    }

    var name: String by Delegates.observable("<no name>") {
        prop, old, new ->
        println("$old -> $new")
    }

    var kkk :String by Delegates.observable(""){
        kkkk,old,new -> { println("RIIRIIR")}
    }

    /**
     * Object学习,即：单例
     */
    private fun objectStudy(){
        Class.forName("SingleInstance")
    }

    /**
     * Anko测试
     */
    private fun ankoLayout(){
        startActivity(Intent(this,AnkoLayoutActivity::class.java))
    }

    /**
     * 写Global全局SP值，在另一个App中读取，看能不能读取到
     */
    private fun writeGlobalSP(){
        val prefs = getSharedPreferences("FuckSP", Context.MODE_MULTI_PROCESS)
        val spEdit = prefs.edit()
        spEdit.putString("Value","HaHaHaHa")
        spEdit.commit()
        spEdit.apply()
        toast("SP写入成功")
    }

    /**
     * Kotlin协程
     */
    private fun kotlinCoroutine(){

        val uiContext = UI
        val bgContext = CommonPool
//        Unconfined

        //注：当通过 async 来启动父协程时，将会忽略掉任何异常
        val job = launch(uiContext /**Unconfined、uiContext、bgContext 分别表示主线程、主线程、后台线程*/) {
//            view.showLoading() // ui thread
            val deferred = async(bgContext) {
                delay(5,TimeUnit.SECONDS)
                toast("这是5s后打印出来的日志,模拟耗时操作")
            }
            deferred.await()
//            val result = withTimeoutOrNull(3,TimeUnit.SECONDS){ deferred.await() }
            toast("此得已经获取到结果啦 ")
//            view.showData(result) // ui thread
        }
//        val future = doAsync {  }


//        launch(bgContext) {
//            delay(3000,TimeUnit.MILLISECONDS)
//            println("Hello....")
//        }
//
//        println("world ! ! ! ")
//        Thread.sleep(5000L)

//        runBlocking {  }



    }

    /**
     * 测试代码执行时间
     */
    private  fun measureTime(){
        val time = measureTimeMillis {
//            method one
//            method two
        }
//        measureNanoTime {  }
        println("time = $time")
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
