package com.demo.leixiang.kotlinanko.listener

/**
 * Created by lei.xiang on 2018/4/25.
 */
interface OnItemClickListener<T> {

    fun onItemClick(position: Int, item: T?)
}