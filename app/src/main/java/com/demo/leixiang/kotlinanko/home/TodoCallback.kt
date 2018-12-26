package com.demo.leixiang.kotlinanko.home

/**
 * created by xianglei
 * 2018/12/26 19:11
 */
interface TodoCallback<T> {

    fun del(data: T?)
    fun change(data: T?)
}