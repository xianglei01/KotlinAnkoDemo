package com.demo.leixiang.kotlinanko.home

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.data.Memorandum
import com.demo.leixiang.kotlinanko.edit.EditActivity
import com.demo.leixiang.kotlinanko.listener.OnItemClickListener
import org.jetbrains.anko.find
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

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        HomeView().setContentView(this)
        val recycleView = find<RecyclerView>(R.id.recycle)
        recycleView.layoutManager = LinearLayoutManager(this)
        val adapter = MemorandumAdapter(this, list)
        recycleView.adapter = adapter
        adapter.setOnItemClickListener({ position, item ->
            startActivity<EditActivity>()
        })
    }
}