package com.demo.leixiang.kotlinanko.home

import com.demo.leixiang.kotlinanko.data.Memorandum

/**
 * Created by lei.xiang on 2018/5/14.
 */
interface HomeDataSource {

    fun queryMemorandum(action: (List<Memorandum>?) -> Unit)

    fun delMemorandum(item: Memorandum)
}