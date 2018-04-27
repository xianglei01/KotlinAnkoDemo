package com.demo.leixiang.kotlinanko.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.edit.EditActivity
import com.demo.leixiang.kotlinanko.sql.DataBaseManager
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.find
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity

/**
 * Created by lei.xiang on 2018/4/24.
 */
class HomeActivity : AppCompatActivity() {

    private lateinit var mRecycleView: RecyclerView
    private lateinit var mAdapter: MemorandumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeView().setContentView(this)
        supportActionBar?.setTitle(R.string.home_title)
        mRecycleView = find(R.id.recycle)
        mRecycleView.layoutManager = LinearLayoutManager(this)
        mAdapter = MemorandumAdapter(this, null)
        mRecycleView.adapter = mAdapter
        initListener()
    }

    override fun onResume() {
        super.onResume()
        async(UI) {
            DataBaseManager.queryMemorandum(this@HomeActivity, { list ->
                mAdapter.setData(list)
            })
        }
    }

    fun initListener() {
        mAdapter.setOnItemClickListener({ position, item ->
            if (item != null) {
                startActivity<EditActivity>("Memorandum" to item)
            }
        })
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.home_add -> {
                startActivity<EditActivity>()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}