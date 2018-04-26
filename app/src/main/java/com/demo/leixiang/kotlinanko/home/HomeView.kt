package com.demo.leixiang.kotlinanko.home

import android.content.Context
import android.view.View
import com.demo.leixiang.kotlinanko.R
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by lei.xiang on 2018/4/24.
 */
class HomeView : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>): View {
        return with(ui) {
            recyclerView {
                lparams(matchParent, matchParent)
                id = R.id.recycle
            }
        }
    }
}