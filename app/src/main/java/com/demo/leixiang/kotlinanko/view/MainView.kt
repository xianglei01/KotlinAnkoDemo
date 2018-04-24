package com.demo.leixiang.kotlinanko.view

import android.content.Context
import android.view.View
import com.demo.leixiang.kotlinanko.data.IDS
import com.demo.leixiang.kotlinanko.edit.EditActivity
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onItemClick

/**
 * Created by lei.xiang on 2018/4/24.
 */
class MainView : AnkoComponent<Context> {


    override fun createView(ui: AnkoContext<Context>): View {
        return with(ui) {
            verticalLayout {
                listView {
                    id = IDS.MAIN.ID_LIST
                    adapter = MemorandumAdapter(ui.ctx)
                    onItemClick { parent, view, position, id ->
                        ui.startActivity<EditActivity>()
                    }
                }.lparams(matchParent, matchParent)
            }
        }
    }
}