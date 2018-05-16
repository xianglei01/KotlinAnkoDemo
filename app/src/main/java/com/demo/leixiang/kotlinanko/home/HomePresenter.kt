package com.demo.leixiang.kotlinanko.home

import com.demo.leixiang.kotlinanko.data.Memorandum

/**
 * Created by lei.xiang on 2018/5/14.
 */
class HomePresenter(private var repository: HomeDataSource, private var view: HomeContract.View) : HomeContract.Presenter {

    override fun refreshList() {
        repository.queryMemorandum({ list ->
            view.refreshDone(list)
        })
    }

    override fun delItem(item: Memorandum) {
        repository.delMemorandum(item)
    }
}