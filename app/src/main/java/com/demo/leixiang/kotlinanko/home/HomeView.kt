package com.demo.leixiang.kotlinanko.home

import android.content.Context
import android.view.View
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.utils.color
import org.jetbrains.anko.AnkoComponent
import org.jetbrains.anko.AnkoContext
import org.jetbrains.anko.matchParent
import org.jetbrains.anko.recyclerview.v7.recyclerView
import org.jetbrains.anko.support.v4.swipeRefreshLayout

/**
 * Created by lei.xiang on 2018/4/24.
 */
class HomeView : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>): View {
        return with(ui) {
            swipeRefreshLayout {
                id = R.id.swipe_refresh
                setColorSchemeColors(ui.ctx.color(R.color.red_ff4d6b))
                recyclerView {
                    id = R.id.recycle
                    lparams(matchParent, matchParent)
                }
            }
        }
    }
}