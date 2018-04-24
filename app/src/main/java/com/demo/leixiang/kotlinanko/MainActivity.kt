package com.demo.leixiang.kotlinanko

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.demo.leixiang.kotlinanko.data.IDS.MAIN
import com.demo.leixiang.kotlinanko.view.MainView
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.sdk25.coroutines.textChangedListener

class MainActivity : AppCompatActivity() {

    private lateinit var mStr : String
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MainView().setContentView(this)

    }
}
