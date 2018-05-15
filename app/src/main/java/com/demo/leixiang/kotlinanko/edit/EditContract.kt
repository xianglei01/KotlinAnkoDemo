package com.demo.leixiang.kotlinanko.edit

import android.content.Context
import com.demo.leixiang.kotlinanko.base.BasePresenter
import com.demo.leixiang.kotlinanko.base.BaseView
import com.demo.leixiang.kotlinanko.data.Memorandum

/**
 * Created by lei.xiang on 2018/4/24.
 */
class EditContract {

    interface View : BaseView {
        fun finishPage()
        fun editNull()
    }

    interface Presenter : BasePresenter {
        fun saveMemorandum(ctx: Context, memorandum: Memorandum)
    }
}