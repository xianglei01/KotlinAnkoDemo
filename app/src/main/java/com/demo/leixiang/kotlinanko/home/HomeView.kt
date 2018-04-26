package com.demo.leixiang.kotlinanko.home

import android.content.Context
import android.view.Gravity
import android.view.View
import com.demo.leixiang.kotlinanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.recyclerview.v7.recyclerView

/**
 * Created by lei.xiang on 2018/4/24.
 */
class HomeView : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>): View {
        return with(ui) {
            relativeLayout {
                recyclerView {
                    id = R.id.recycle
                    lparams(matchParent, matchParent)
                }
                imageView(R.mipmap.ic_add) {
                    id = R.id.home_add
                }.lparams {
                    below(R.id.recycle)
                    centerInParent()
                }
                textView(R.string.home_add) {
                    id = R.id.home_add_tv
                    textColorResource = R.color.gray_999999
                    textSize = 16f
                    topPadding = dip(3)
                }.lparams {
                    below(R.id.home_add)
                    centerHorizontally()
                }
            }
        }
    }
}