package com.demo.leixiang.kotlinanko.addtodo

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.EditText
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.base.BaseActivity
import com.demo.leixiang.kotlinanko.data.Item
import com.demo.leixiang.kotlinanko.view.AddToDoView
import org.jetbrains.anko.find
import org.jetbrains.anko.toast

/**
 * created by xianglei
 * 2018/12/26 18:27
 */
class AddToDoActivity : BaseActivity(AddToDoView()), AddToDoContract.View {
    private lateinit var mEditName: EditText
    private lateinit var mEditNum: EditText
    private lateinit var mItem: Item
    private lateinit var mPresenter: AddToDoPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setTitle(R.string.edit_title)
    }

    override fun initData() {
        super.initData()
        mPresenter = AddToDoPresenter(this)
        var model = intent.getSerializableExtra("Item")
        mItem = if (model == null) Item("", false, "1") else model as Item
    }

    override fun initView() {
        mEditName = find(R.id.edit_title)
        mEditNum = find(R.id.edit_content)
        mEditName.setText(mItem.name)
        mEditNum.setText("${mItem.number}")
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.edit_commit -> {
                var name = mEditName.text.toString()
                name = if (name.isEmpty()) getString(R.string.edit_title_null) else name
                var number = mEditNum.text.toString()
                mItem.name = name
                mItem.number = number
                mItem.number = if (mItem.number.toInt() > 0) mItem.number else "1"
                mPresenter.saveItem(mItem)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun finishPage() {
        finish()
    }

    override fun editNull() {
        toast(R.string.edit_add_null)
    }
}