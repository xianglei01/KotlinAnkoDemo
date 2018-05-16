package com.demo.leixiang.kotlinanko.sql

import com.demo.leixiang.kotlinanko.data.Memorandum
import com.demo.leixiang.kotlinanko.listener.CallBack
import com.demo.leixiang.kotlinanko.sql.TABLE_MEMORANDUM.db_id
import com.demo.leixiang.kotlinanko.sql.TABLE_MEMORANDUM.db_memorandum_time
import com.demo.leixiang.kotlinanko.sql.TABLE_MEMORANDUM.db_table_memorandum
import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.experimental.async
import org.jetbrains.anko.db.*

/**
 * Created by lei.xiang on 2018/4/26.
 */
object DataBaseManager {

    fun insertMemorandum(memorandum: Memorandum, action: (Boolean) -> Unit) {
        DataBaseOpenHelper.instance.use {
            insert(db_table_memorandum, db_memorandum_time to memorandum.time, TABLE_MEMORANDUM.db_memorandum_title to memorandum.title,
                    TABLE_MEMORANDUM.db_memorandum_content to memorandum.content)
        }
    }

    fun replaceMemorandum(memorandum: Memorandum) {
        DataBaseOpenHelper.instance.use {
            if (memorandum.id == 0) {
                replace(db_table_memorandum, db_memorandum_time to memorandum.time, TABLE_MEMORANDUM.db_memorandum_title to memorandum.title,
                        TABLE_MEMORANDUM.db_memorandum_content to memorandum.content)
            } else {
                replace(db_table_memorandum, db_id to memorandum.id, db_memorandum_time to memorandum.time, TABLE_MEMORANDUM.db_memorandum_title to memorandum.title,
                        TABLE_MEMORANDUM.db_memorandum_content to memorandum.content)
            }
        }
    }

    fun queryMemorandum(action: (List<Memorandum>?) -> Unit) {
        DataBaseOpenHelper.instance.use {
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

    fun delMemorandum(memorandum: Memorandum) {
        DataBaseOpenHelper.instance.use {
            delete(db_table_memorandum, "$db_id = ${memorandum.id}")
        }
    }

}