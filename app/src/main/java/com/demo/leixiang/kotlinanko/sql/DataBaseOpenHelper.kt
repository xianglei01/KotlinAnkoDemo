package com.demo.leixiang.kotlinanko.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.demo.leixiang.kotlinanko.App
import com.demo.leixiang.kotlinanko.sql.TABLE_MEMORANDUM.db_id
import com.demo.leixiang.kotlinanko.sql.TABLE_MEMORANDUM.db_memorandum_content
import com.demo.leixiang.kotlinanko.sql.TABLE_MEMORANDUM.db_memorandum_time
import com.demo.leixiang.kotlinanko.sql.TABLE_MEMORANDUM.db_memorandum_title
import com.demo.leixiang.kotlinanko.sql.TABLE_MEMORANDUM.db_table_memorandum
import com.demo.leixiang.kotlinanko.sql.TABLE_TODO.db_table_todo
import com.demo.leixiang.kotlinanko.sql.TABLE_TODO.db_todo_done
import com.demo.leixiang.kotlinanko.sql.TABLE_TODO.db_todo_name
import com.demo.leixiang.kotlinanko.sql.TABLE_TODO.db_todo_num
import org.jetbrains.anko.db.*

/**
 * Created by lei.xiang on 2018/4/26.
 */
class DataBaseOpenHelper(ctx: Context = App.instance) : ManagedSQLiteOpenHelper(ctx, DB_NAME, null, DB_VERSION) {

    companion object {
        val DB_NAME = "Kotlin_Anko_Demo"
        val DB_VERSION = 1
        val instance by lazy { DataBaseOpenHelper() }
//        private var instance: DataBaseOpenHelper? = null
//
//        @Synchronized
//        fun getInstance(ctx: Context): DataBaseOpenHelper {
//            if (instance == null) {
//                instance = DataBaseOpenHelper(ctx)
//            }
//            return instance!!
//        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(db_table_memorandum, true,
                db_id to INTEGER + PRIMARY_KEY + UNIQUE,
                db_memorandum_time to TEXT,
                db_memorandum_title to TEXT,
                db_memorandum_content to TEXT)
        db.createTable(db_table_todo, true, db_todo_name to TEXT + PRIMARY_KEY + UNIQUE,
                db_todo_done to BLOB,
                db_todo_num to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

}