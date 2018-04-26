package com.demo.leixiang.kotlinanko.edit

import android.app.Activity
import android.os.Bundle
import android.widget.ImageView
import com.demo.leixiang.kotlinanko.R
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.setContentView

/**
 * Created by lei.xiang on 2018/4/24.
 */
class EditActivity : Activity(), EditContract.View {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EditView().setContentView(this)
        find<ImageView>(R.id.edit_title_btn).onClick {

        }
    }
}