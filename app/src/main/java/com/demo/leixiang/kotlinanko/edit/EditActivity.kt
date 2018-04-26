package com.demo.leixiang.kotlinanko.edit

import android.app.Activity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.sql.DataBaseManager
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

/**
 * Created by lei.xiang on 2018/4/24.
 */
class EditActivity : Activity(), EditContract.View {

    private lateinit var mEditTitle: EditText
    private lateinit var mEditContent: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EditView().setContentView(this)
        initView()
    }

    private fun initView() {
        mEditTitle = find(R.id.edit_name)
        mEditContent = find(R.id.edit_content)
        mEditTitle.setText(intent.getStringExtra("title"))
        mEditContent.setText(intent.getStringExtra("content"))
        intent.getStringExtra("content")
        find<ImageView>(R.id.edit_title_btn).onClick {
            var title = mEditTitle.text.toString()
            if (title.isEmpty()) {
                title = getString(R.string.edit_title_null)
            }
            var content = mEditContent.text.toString()
            if (content.isNotEmpty()) {
                //存储数据关闭页面
                DataBaseManager.insertMemorandum(this@EditActivity, System.currentTimeMillis().toString()
                        , title, content)
                finish()
            } else {
                toast(R.string.edit_null)
            }
        }
    }
}