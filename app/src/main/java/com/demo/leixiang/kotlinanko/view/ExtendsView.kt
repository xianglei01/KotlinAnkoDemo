package com.demo.leixiang.kotlinanko.view

import android.content.Context
import android.view.ViewManager
import com.daimajia.swipe.SwipeLayout
import org.jetbrains.anko.custom.ankoView

/**
 * Created by lei.xiang on 2018/5/14.
 */
object ExtendsView {

    inline fun ViewManager.slideView(context: Context): SlideView = slideView(context) {}
    inline fun ViewManager.slideView(context: Context, init: SlideView.() -> Unit): SlideView {
        return ankoView({ SlideView(context, null) }, 0, init)
    }

    inline fun ViewManager.swipeLayout(context: Context): SwipeLayout = swipeLayout(context) {}
    inline fun ViewManager.swipeLayout(context: Context, init: SwipeLayout.() -> Unit): SwipeLayout {
        return ankoView({ SwipeLayout(context, null) }, 0, init)
    }


}