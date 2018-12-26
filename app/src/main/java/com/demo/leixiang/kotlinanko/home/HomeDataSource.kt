package com.demo.leixiang.kotlinanko.home

import com.demo.leixiang.kotlinanko.data.Item

/**
 * Created by lei.xiang on 2018/5/14.
 */
interface HomeDataSource {

    fun queryItem(action: (List<Item>?) -> Unit)

    fun delItem(item: Item)

    fun itemDone(item: Item)

}