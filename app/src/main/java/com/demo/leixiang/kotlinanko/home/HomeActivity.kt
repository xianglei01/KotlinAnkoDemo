package com.demo.leixiang.kotlinanko.home

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.Menu
import android.view.MenuItem
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.addtodo.AddToDoActivity
import com.demo.leixiang.kotlinanko.addtodo.TodoAdapter
import com.demo.leixiang.kotlinanko.base.BaseActivity
import com.demo.leixiang.kotlinanko.data.Item
import org.jetbrains.anko.find
import org.jetbrains.anko.startActivity

/**
 * Created by lei.xiang on 2018/4/24.
 */
class HomeActivity : BaseActivity(HomeView()), HomeContract.View {

    private lateinit var mRecycleView: RecyclerView
    private lateinit var mAdapter: TodoAdapter
    private lateinit var mSwipeRefreshLayout: SwipeRefreshLayout
    private lateinit var mPresenter: HomePresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.setTitle(R.string.home_title)
    }

    override fun onResume() {
        super.onResume()
        mSwipeRefreshLayout.post {
            mSwipeRefreshLayout.isRefreshing = true
            mPresenter.refreshList()
        }
    }

    override fun initView() {
        super.initView()
        mSwipeRefreshLayout = find(R.id.swipe_refresh)
        mRecycleView = find(R.id.recycle)
        mRecycleView.layoutManager = LinearLayoutManager(this)
        mAdapter = TodoAdapter(this, null)
        mRecycleView.adapter = mAdapter
        mPresenter = HomePresenter(HomeRepository(), this)
    }

    override fun initListener() {
        mAdapter.setOnItemClickListener { position, item ->
            if (item != null) {
                startActivity<AddToDoActivity>("Item" to item)
            }
        }
        mAdapter.setOnDelListener(object : TodoCallback<Item> {
            override fun del(item: Item?) {
                if (item != null) {
                    mPresenter.delItem(item)
                    mSwipeRefreshLayout.isRefreshing = true
                    mPresenter.refreshList()
                }
            }

            override fun change(item: Item?) {
                if (item != null) {
                    mPresenter.changeItem(item)
                }
            }

        })
        mSwipeRefreshLayout.setOnRefreshListener {
            mPresenter.refreshList()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.home_add -> {
                startActivity<AddToDoActivity>()
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun refreshDone(list: List<Item>?) {
        mAdapter.setData(list)
        mSwipeRefreshLayout.isRefreshing = false
    }
}