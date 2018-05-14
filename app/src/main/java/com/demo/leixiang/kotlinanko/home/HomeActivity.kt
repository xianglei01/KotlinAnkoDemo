package com.demo.leixiang.kotlinanko.home

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.base.BaseActivity
import com.demo.leixiang.kotlinanko.edit.EditActivity
import com.demo.leixiang.kotlinanko.sql.DataBaseManager
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

/**
 * Created by lei.xiang on 2018/4/24.
 */
class HomeActivity : BaseActivity(HomeView()) {

    private lateinit var mRecycleView: RecyclerView
    private lateinit var mAdapter: MemorandumAdapter
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setTitle(R.string.home_title)
    }

    override fun onResume() {
        super.onResume()
        mSwipeRefreshLayout.post {
            mSwipeRefreshLayout.isRefreshing = true
            query()
        }
    }

    override fun initView() {
        super.initView()
        mSwipeRefreshLayout = find(R.id.swipe_refresh)
        mRecycleView = find(R.id.recycle)
        mRecycleView.layoutManager = LinearLayoutManager(this)
        mAdapter = MemorandumAdapter(this, null)
        mRecycleView.adapter = mAdapter
    }

    override fun initListener() {
        mAdapter.setOnItemClickListener({ position, item ->
            if (item != null) {
                startActivity<EditActivity>("Memorandum" to item)
            }
        })
        mAdapter.setOnDelListener { item ->
            if (item != null) {
                DataBaseManager.delMemorandum(this, item)
                mSwipeRefreshLayout.isRefreshing = true
                query()
            }
        }
        mSwipeRefreshLayout.setOnRefreshListener {
            query()
        }
    }

    private fun query() {
        async(UI) {
            DataBaseManager.queryMemorandum(this@HomeActivity, { list ->
                mAdapter.setData(list)
                mSwipeRefreshLayout.isRefreshing = false
            })
        }
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