package com.demo.leixiang.kotlinanko.utils

import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by lei.xiang on 2018/4/26.
 */
object DateUtil {

    fun millisToDate(millisStr: String?): String {
        val simpleDateFormat = SimpleDateFormat("yyyy.MM.dd HH:mm")//24小时制
        val millis = millisStr?.toLong()
        val date = Date()
        date.time = millis ?: 0
        return simpleDateFormat.format(date)
    }
}