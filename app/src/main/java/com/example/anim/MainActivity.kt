package com.example.anim

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    private lateinit var button: Button
    private lateinit var textView1: TextView
    private lateinit var textView2: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button = findViewById(R.id.btn_jump)
        textView1 = findViewById(R.id.tv_test1)
        textView2 = findViewById(R.id.tv_text2)

        //设置 View加载时的出场动画
//        AnimManager.showViewWithAnim(this, textView1, R.anim.screen_zoom_in)
        button.setOnClickListener {

            //设置 Activity跳转时的出入动画
//            val intent = Intent(this, MainActivity2::class.java)
//            AnimManager.startActivityWithAnim(this,intent,R.anim.fade_in,R.anim.fade_out)

            //设置 当button点击后 View从 隐藏--->显示 时的出场动画
//            AnimManager.loadViewWithAnim(this, textView1, R.anim.screen_zoom_in)

            //设置 每点击一次就展示一次属性动画
//            AnimManager.showAnimInView(this,textView1,R.animator.rotate)

            //设置 View共享
//            AnimManager.makeTransitionAnim(this,MainActivity2::class.java,UtilPair.create(textView1,"textView1"),UtilPair.create(textView2,"textView2"))
        }

    }

    override fun onStart() {
        super.onStart()
        //等同于在View被加载前调用loadViewWithAnim()
//        AnimManager.showAnimInView(this,textView1,R.animator.rotate)
    }
}