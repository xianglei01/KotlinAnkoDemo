package com.demo.leixiang.kotlinanko.base.adapter

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * Created by lei.xiang on 2018/4/24.
 */
open abstract class BaseListAdapter<T>(val ctx: Context) : BaseAdapter() {

    private var list: List<T>? = null

    abstract override fun getView(position: Int, view: View?, parent: ViewGroup?): View

    override fun getItem(position: Int): T? = list?.get(position)

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = list?.size ?: 0
}