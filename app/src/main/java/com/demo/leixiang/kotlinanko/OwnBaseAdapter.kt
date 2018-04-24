package com.demo.leixiang.kotlinanko

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter

/**
 * Created by lei.xiang on 2018/4/24.
 */
open abstract class OwnBaseAdapter<T> : BaseAdapter {

    private var list: List<T>? = null
    var ctx: Context

    constructor(ctx: Context) {
        this.ctx = ctx
    }

    abstract override fun getView(position: Int, view: View?, parent: ViewGroup?): View

    override fun getItem(position: Int): T? = list?.get(position)

    override fun getItemId(position: Int): Long = position.toLong()

    override fun getCount(): Int = 5
}