package com.demo.leixiang.kotlinanko.edit

import com.demo.leixiang.kotlinanko.data.Memorandum
import com.demo.leixiang.kotlinanko.sql.DataBaseManager

/**
 * Created by lei.xiang on 2018/4/24.
 */
class EditPresenter(private var view: EditContract.View) : EditContract.Presenter {

    override fun saveMemorandum(memorandum: Memorandum) {
        if (memorandum.content.isNotEmpty()) {
            //存储数据关闭页面
            DataBaseManager.replaceMemorandum(memorandum)
            view.finishPage()
        } else {
            view.editNull()
        }
    }

}