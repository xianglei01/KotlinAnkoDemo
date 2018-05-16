package com.demo.leixiang.kotlinanko.home

import android.util.Log
import com.demo.leixiang.kotlinanko.data.Memorandum
import com.demo.leixiang.kotlinanko.listener.CallBack
import com.demo.leixiang.kotlinanko.sql.DataBaseManager

/**
 * Created by lei.xiang on 2018/5/14.
 */
class HomeRepository : HomeDataSource {

    override fun delMemorandum(item: Memorandum) {
        DataBaseManager.delMemorandum(item)
    }

    override fun queryMemorandum(action: (List<Memorandum>?) -> Unit) {
        DataBaseManager.queryMemorandum({ list ->
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