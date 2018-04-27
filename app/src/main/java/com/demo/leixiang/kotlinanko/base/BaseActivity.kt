package com.demo.leixiang.kotlinanko.base

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.setContentView

/**
 * Created by lei.xiang on 2018/4/27.
 */
abstract class BaseActivity(var view: AnkoComponent<Context>) : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view.setContentView(this)
        initData()
        initView()
        initListener()
    }

    open fun initData() {}

    open fun initView() {}

    open fun initListener() {}
}