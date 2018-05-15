package com.demo.leixiang.kotlinanko.home

import android.content.Context
import android.util.Log
import com.demo.leixiang.kotlinanko.data.Memorandum
import com.demo.leixiang.kotlinanko.listener.CallBack
import com.demo.leixiang.kotlinanko.sql.DataBaseManager

/**
 * Created by lei.xiang on 2018/5/14.
 */
class HomeRepository : HomeDataSource {

    override fun delMemorandum(ctx: Context, item: Memorandum) {
        DataBaseManager.delMemorandum(ctx, item)
    }

    override fun queryMemorandum(ctx: Context, action: (List<Memorandum>?) -> Unit) {
        DataBaseManager.queryMemorandum(ctx, { list ->
            Log.d("打印===", "list")
            val listener = object : CallBack<List<Memorandum>> {
                override fun callBack(data: List<Memorandum>?) {
                    action(data)
                }
            }
            listener.callBack(list)
        })
    }
}