package com.demo.leixiang.kotlinanko.home

import android.content.Context
import com.demo.leixiang.kotlinanko.data.Memorandum

/**
 * Created by lei.xiang on 2018/5/14.
 */
interface HomeDataSource {

    fun queryMemorandum(ctx: Context, action: (List<Memorandum>?) -> Unit)

    fun delMemorandum(ctx: Context, item: Memorandum)
}