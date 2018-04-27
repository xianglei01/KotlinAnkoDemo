package com.demo.leixiang.kotlinanko.data

import java.io.Serializable

/**
 * Created by lei.xiang on 2018/4/24.
 */
data class Memorandum(var id: Int, var time: String, var title: String, var content: String) : Serializable