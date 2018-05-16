package com.demo.leixiang.kotlinanko

import android.app.Application
import kotlin.properties.Delegates

/**
 * Created by lei.xiang on 2018/5/15.
 */
class App: Application() {

    companion object {
        var instance:App by Delegates.notNull()
    }
    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}