package com.demo.leixiang.kotlinanko.home

import android.util.Log
import com.demo.leixiang.kotlinanko.data.Item
import com.demo.leixiang.kotlinanko.data.Memorandum
import com.demo.leixiang.kotlinanko.listener.CallBack
import com.demo.leixiang.kotlinanko.sql.DataBaseManager

/**
 * Created by lei.xiang on 2018/5/14.
 */
class HomeRepository : HomeDataSource {

    override fun itemDone(item: Item) {
        DataBaseManager.replaceTodoItem(item)
    }

    override fun delItem(item: Item) {
        DataBaseManager.delTodoItem(item)
    }

    override fun queryItem(action: (List<Item>?) -> Unit) {
        DataBaseManager.queryTodoList { list ->
            Log.d("打印===", "list")
            val listener = object : CallBack<List<Item>> {
                override fun callBack(data: List<Item>?) {
                    action(data)
                }
            }
            listener.callBack(list)
        }
    }
}