package com.demo.leixiang.kotlinanko.home

import com.demo.leixiang.kotlinanko.base.BasePresenter
import com.demo.leixiang.kotlinanko.base.BaseView
import com.demo.leixiang.kotlinanko.data.Item

/**
 * Created by lei.xiang on 2018/5/14.
 */
class HomeContract {

    interface View : BaseView {
        fun refreshDone(list: List<Item>?)
    }

    interface Presenter : BasePresenter {
        fun refreshList()
        fun delItem(item: Item)
        fun changeItem(item: Item)
    }
}