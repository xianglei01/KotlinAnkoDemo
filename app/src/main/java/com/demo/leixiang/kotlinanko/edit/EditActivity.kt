package com.demo.leixiang.kotlinanko.edit

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.base.BaseActivity
import com.demo.leixiang.kotlinanko.data.Memorandum
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

/**
 * Created by lei.xiang on 2018/4/24.
 */
class EditActivity : BaseActivity(EditView()), EditContract.View {

    private lateinit var mEditTitle: EditText
    private lateinit var mEditContent: EditText
    private lateinit var mMemorandum: Memorandum
    private lateinit var mPresenter: EditPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setTitle(R.string.edit_title)
    }

    override fun initData() {
        super.initData()
        mPresenter = EditPresenter(this)
        var model = intent.getSerializableExtra("Memorandum")
        mMemorandum = if (model == null) Memorandum(0, "", "", "") else model as Memorandum
    }

    override fun initView() {
        mEditTitle = find(R.id.edit_title)
        mEditContent = find(R.id.edit_content)
        mEditTitle.setText(mMemorandum.title)
        mEditContent.setText(mMemorandum.content)
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
                mMemorandum.title = title
                mMemorandum.content = content
                mMemorandum.time = System.currentTimeMillis().toString()
                mPresenter.saveMemorandum(mMemorandum)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun finishPage() {
        finish()
    }

    override fun editNull() {
        toast(R.string.edit_null)
    }
}