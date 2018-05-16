package com.demo.leixiang.kotlinanko.utils

import android.content.Context
import android.support.v4.content.ContextCompat
import com.demo.leixiang.kotlinanko.sql.DataBaseOpenHelper

/**
 * Created by lei.xiang on 2018/5/15.
 */
fun Context.color(res: Int): Int = ContextCompat.getColor(this, res)

val Context.database: DataBaseOpenHelper
    get() = DataBaseOpenHelper.instance