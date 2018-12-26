package com.demo.leixiang.kotlinanko.addtodo

import com.demo.leixiang.kotlinanko.base.BasePresenter
import com.demo.leixiang.kotlinanko.base.BaseView
import com.demo.leixiang.kotlinanko.data.Item

/**
 * created by xianglei
 * 2018/12/26 18:31
 */
class AddToDoContract{
    interface View : BaseView {
        fun finishPage()
        fun editNull()
    }

    interface Presenter : BasePresenter {
        fun saveItem(item: Item)
    }
}