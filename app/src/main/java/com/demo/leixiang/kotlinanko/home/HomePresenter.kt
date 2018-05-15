package com.demo.leixiang.kotlinanko.home

import android.content.Context
import com.demo.leixiang.kotlinanko.data.Memorandum

/**
 * Created by lei.xiang on 2018/5/14.
 */
class HomePresenter(private var repository: HomeDataSource, private var view: HomeContract.View) : HomeContract.Presenter {

    override fun refreshList(ctx: Context) {
        repository.queryMemorandum(ctx, { list ->
            view.refreshDone(list)
        })
    }

    override fun delItem(ctx: Context, item: Memorandum) {
        repository.delMemorandum(ctx, item)
    }
}