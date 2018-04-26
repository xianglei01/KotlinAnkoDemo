package com.demo.leixiang.kotlinanko.sql

import android.content.Context
import com.demo.leixiang.kotlinanko.data.Memorandum
import com.demo.leixiang.kotlinanko.listener.QueryCallBack
import com.demo.leixiang.kotlinanko.sql.DateBaseContanst.db_memorandum_time
import com.demo.leixiang.kotlinanko.sql.DateBaseContanst.db_table_memorandum
import org.jetbrains.anko.db.*

/**
 * Created by lei.xiang on 2018/4/26.
 */
object DataBaseManager {

    fun insertMemorandum(ctx: Context, time: String, title: String, content: String) {
        DataBaseOpenHelper(ctx).use {
            insert(db_table_memorandum, db_memorandum_time to time, DateBaseContanst.db_memorandum_title to title,
                    DateBaseContanst.db_memorandum_content to content)
        }
    }

    fun replaceMemorandum(ctx: Context, time: String, title: String, content: String) {
        DataBaseOpenHelper(ctx).use {
            replace(db_table_memorandum, db_memorandum_time to time, DateBaseContanst.db_memorandum_title to title,
                    DateBaseContanst.db_memorandum_content to content)
        }
    }

    fun queryMemorandum(ctx: Context, action: (List<Memorandum>?) -> Unit) {
        System.currentTimeMillis()
        DataBaseOpenHelper(ctx).use {
            val list = select(db_table_memorandum).orderBy(db_memorandum_time, SqlOrderDirection.DESC)
                    .parseList(classParser<Memorandum>())
            val listener = object : QueryCallBack<List<Memorandum>> {
                override fun onQueryCallBack(data: List<Memorandum>?) {
                    action(data)
                }
            }
            listener.onQueryCallBack(list)
        }
    }


}