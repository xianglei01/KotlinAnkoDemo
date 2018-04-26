package com.demo.leixiang.kotlinanko.sql

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.demo.leixiang.kotlinanko.sql.DateBaseContanst.db_memorandum_content
import com.demo.leixiang.kotlinanko.sql.DateBaseContanst.db_memorandum_time
import com.demo.leixiang.kotlinanko.sql.DateBaseContanst.db_memorandum_title
import com.demo.leixiang.kotlinanko.sql.DateBaseContanst.db_table_memorandum
import org.jetbrains.anko.db.*

/**
 * Created by lei.xiang on 2018/4/26.
 */
class DataBaseOpenHelper(ctx: Context) : ManagedSQLiteOpenHelper(ctx, "Kotlin_Anko_Demo", null) {

    companion object {
        private var instance: DataBaseOpenHelper? = null

        @Synchronized
        fun getInstance(ctx: Context): DataBaseOpenHelper {
            if (instance == null) {
                instance = DataBaseOpenHelper(ctx)
            }
            return instance!!
        }
    }

    override fun onCreate(db: SQLiteDatabase) {
        db.createTable(db_table_memorandum, true,
                "id" to INTEGER + PRIMARY_KEY + UNIQUE,
                db_memorandum_time to TEXT,
                db_memorandum_title to TEXT,
                db_memorandum_content to TEXT)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
    }

    val Context.database: DataBaseOpenHelper
        get() = DataBaseOpenHelper.getInstance(getApplicationContext())

}