package com.demo.leixiang.kotlinanko.sql

import android.content.Context
import com.demo.leixiang.kotlinanko.data.Memorandum
import com.demo.leixiang.kotlinanko.listener.CallBack
import com.demo.leixiang.kotlinanko.sql.DateBaseConstant.db_id
import com.demo.leixiang.kotlinanko.sql.DateBaseConstant.db_memorandum_time
import com.demo.leixiang.kotlinanko.sql.DateBaseConstant.db_table_memorandum
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.db.*

/**
 * Created by lei.xiang on 2018/4/26.
 */
object DataBaseManager {

    fun insertMemorandum(ctx: Context, memorandum: Memorandum, action: (Boolean) -> Unit) {
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
            async(UI) {
                val listener = object : CallBack<List<Memorandum>> {
                    override fun callBack(data: List<Memorandum>?) {
                        action(data)
                    }
                }
                listener.callBack(list)
            }
        }
    }

    fun delMemorandum(ctx: Context, memorandum: Memorandum) {
        DataBaseOpenHelper(ctx).use {
            delete(db_table_memorandum, "$db_id = ${memorandum.id}")
        }
    }

}