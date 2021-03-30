package com.example.anim

import android.animation.AnimatorInflater
import android.app.Activity
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.util.Pair
import android.view.View
import android.view.animation.AnimationUtils


object AnimManager {

    /**
     * 启动另一Activity 并伴随Activity的出入动画
     */
    fun startActivityWithAnim(activity: Activity, intent: Intent, inAnim: Int, outAnim: Int) {
        activity.startActivity(intent)
        activity.overridePendingTransition(inAnim, outAnim)
    }

    /**
     * 为View设定加载补间动画
     * 在View被加载前调用
     * 则加载View时会有动画效果
     * 适用于两种情况
     * 1.View直接显示时的出场动画
     * 2.特定条件下View从 隐藏--->显示 时的出场动画
     */
    fun loadViewWithAnim(context: Context, view: View, loadAnim: Int) {
        val showAnimation = AnimationUtils.loadAnimation(context, loadAnim)
        view.animation = showAnimation
        view.visibility = View.VISIBLE
    }

    /**
     * 在View上加载属性动画
     * 与 loadViewWithAnim() 不同之处在于
     * 该方法是在View上展示动画 而 loadViewWithAnim() 是为View设定加载动画
     * 调用一次展示一次动画 不局限于加载View时才展现
     * 在 OnStart() 中调用可实现在View加载时展示动画 等同于在View被加载前调用loadViewWithAnim()
     */
    fun showAnimInView(context: Context, view: View, anim: Int) {
        val animator = AnimatorInflater.loadAnimator(context, anim)
        animator.setTarget(view)
        animator.start()
    }

    /**
     * 创建共享元素(View)的过渡动画
     * 导入import android.util.Pair as UtilPair
     * AnimManager.makeTransitionAnim(activity,xxx::class.java,UtilPair.create(View1,"View1"),UtilPair.create(View2,"View2")...)
     */
    fun makeTransitionAnim(activity: Activity, cls: Class<*>, vararg sharedElements: Pair<View, String>) {
        val intent = Intent(activity, cls)
        val options = ActivityOptions
                .makeSceneTransitionAnimation(activity, *sharedElements)
        activity.startActivity(intent, options.toBundle())
    }
}