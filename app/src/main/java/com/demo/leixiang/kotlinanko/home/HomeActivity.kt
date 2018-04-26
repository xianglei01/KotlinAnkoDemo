package com.demo.leixiang.kotlinanko.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.widget.ImageView
import android.widget.TextView
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.data.Memorandum
import com.demo.leixiang.kotlinanko.edit.EditActivity
import com.demo.leixiang.kotlinanko.sql.DataBaseManager
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick
import org.jetbrains.anko.setContentView
import org.jetbrains.anko.startActivity
import java.util.*

/**
 * Created by lei.xiang on 2018/4/24.
 */
class HomeActivity : AppCompatActivity() {

    private val list: List<Memorandum>
        get() {
            val list = ArrayList<Memorandum>()
            list.add(Memorandum("无题1", "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容", "2018.04.25"))
            list.add(Memorandum("无题2", "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容", "2018.04.24"))
            list.add(Memorandum("无题3", "内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容内容", "2018.04.23"))
            return list
        }

    private lateinit var mRecycleView: RecyclerView
    private lateinit var mBtnAdd: ImageView
    private lateinit var mTvAdd: TextView
    private lateinit var mAdapter: MemorandumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeView().setContentView(this)
        mRecycleView = find(R.id.recycle)
        mBtnAdd = find(R.id.home_add)
        mTvAdd = find(R.id.home_add_tv)
        mRecycleView.layoutManager = LinearLayoutManager(this)
        mAdapter = MemorandumAdapter(this, list)
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
                startActivity<EditActivity>("title" to item.title, "content" to item.content)
            }
        })
        mBtnAdd.onClick {
            startActivity<EditActivity>()
        }
    }
}