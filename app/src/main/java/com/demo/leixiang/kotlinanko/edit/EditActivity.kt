package com.demo.leixiang.kotlinanko.edit

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.data.Memorandum
import com.demo.leixiang.kotlinanko.sql.DataBaseManager
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.toast

/**
 * Created by lei.xiang on 2018/4/24.
 */
class EditActivity : AppCompatActivity(), EditContract.View {

    private lateinit var mEditTitle: EditText
    private lateinit var mEditContent: EditText
    private var mMemorandum: Memorandum? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        EditView().setContentView(this)
        supportActionBar?.setTitle(R.string.edit_title)
        var model = intent.getSerializableExtra("Memorandum")
        if (model != null) {
            mMemorandum = model as Memorandum
        }
        initView()
    }

    private fun initView() {
        mEditTitle = find(R.id.edit_title)
        mEditContent = find(R.id.edit_content)
        mEditTitle.setText(mMemorandum?.title)
        mEditContent.setText(mMemorandum?.content)
        intent.getStringExtra("content")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.edit_commit -> {
                var title = mEditTitle.text.toString()
                title = if (title.isEmpty()) getString(R.string.edit_title_null) else title
                var content = mEditContent.text.toString()
                if (content.isNotEmpty()) {
                    //存储数据关闭页面
                    DataBaseManager.replaceMemorandum(this@EditActivity,
                            Memorandum(mMemorandum?.id ?: 0, System.currentTimeMillis().toString(), title, content))
                    finish()
                } else {
                    toast(R.string.edit_null)
                }
            }
        }
        return super.onOptionsItemSelected(item)
    }
}