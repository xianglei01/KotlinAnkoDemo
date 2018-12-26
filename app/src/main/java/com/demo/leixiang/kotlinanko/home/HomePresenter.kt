package com.demo.leixiang.kotlinanko.home

import com.demo.leixiang.kotlinanko.data.Item

/**
 * Created by lei.xiang on 2018/5/14.
 */
class HomePresenter(private var repository: HomeDataSource, private var view: HomeContract.View) : HomeContract.Presenter {

    override fun changeItem(item: Item) {
        repository.itemDone(item)
    }

    override fun refreshList() {
        repository.queryItem { list ->
            view.refreshDone(list)
        }
    }

    override fun delItem(item: Item) {
        repository.delItem(item)
    }
}