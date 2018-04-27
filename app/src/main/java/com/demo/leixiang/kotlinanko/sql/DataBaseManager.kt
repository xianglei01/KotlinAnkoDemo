package com.demo.leixiang.kotlinanko.sql

import android.content.Context
import com.demo.leixiang.kotlinanko.data.Memorandum
import com.demo.leixiang.kotlinanko.listener.QueryCallBack
import com.demo.leixiang.kotlinanko.sql.DateBaseConstant.db_id
import com.demo.leixiang.kotlinanko.sql.DateBaseConstant.db_memorandum_time
import com.demo.leixiang.kotlinanko.sql.DateBaseConstant.db_table_memorandum
import org.jetbrains.anko.db.*

/**
 * Created by lei.xiang on 2018/4/26.
 */
object DataBaseManager {

    fun insertMemorandum(ctx: Context, memorandum: Memorandum) {
        DataBaseOpenHelper(ctx).use {
            insert(db_table_memorandum, db_memorandum_time to memorandum.time, DateBaseConstant.db_memorandum_title to memorandum.title,
                    DateBaseConstant.db_memorandum_content to memorandum.content)
        }
    }

    fun replaceMemorandum(ctx: Context, memorandum: Memorandum) {
        DataBaseOpenHelper(ctx).use {
            if (memorandum.id == 0) {
                replace(db_table_memorandum, db_memorandum_time to memorandum.time, DateBaseConstant.db_memorandum_title to memorandum.title,
                        DateBaseConstant.db_memorandum_content to memorandum.content)
            } else {
                replace(db_table_memorandum, db_id to memorandum.id, db_memorandum_time to memorandum.time, DateBaseConstant.db_memorandum_title to memorandum.title,
                        DateBaseConstant.db_memorandum_content to memorandum.content)
            }
        }
    }

    fun queryMemorandum(ctx: Context, action: (List<Memorandum>?) -> Unit) {
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