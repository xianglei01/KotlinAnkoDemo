package com.demo.leixiang.kotlinanko.data

import java.io.Serializable

/**
 * created by xianglei
 * 2018/12/26 18:25
 */
data class Item(var name: String, var isDone: Boolean, var number: String) : Serializable