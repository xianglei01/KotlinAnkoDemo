package com.demo.leixiang.kotlinanko.addtodo

import com.demo.leixiang.kotlinanko.data.Item
import com.demo.leixiang.kotlinanko.sql.DataBaseManager

/**
 * created by xianglei
 * 2018/12/26 18:32
 */
class AddToDoPresenter(private var view: AddToDoContract.View) : AddToDoContract.Presenter {
    override fun saveItem(item: Item) {
        if (item.name.isNotEmpty()) {
            //存储数据关闭页面
            DataBaseManager.replaceTodoItem(item)
            view.finishPage()
        } else {
            view.editNull()
        }
    }

}