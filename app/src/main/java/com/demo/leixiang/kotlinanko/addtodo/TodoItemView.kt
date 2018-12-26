package com.demo.leixiang.kotlinanko.addtodo

import android.content.Context
import android.text.TextUtils
import android.view.Gravity
import android.view.View
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.view.ExtendsView.swipeLayout
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * created by xianglei
 * 2018/12/26 18:52
 */
object TodoItemView {
    fun createItemView(ctx: Context): View = with(ctx) {
        cardView {
            lparams(matchParent, wrapContent) {
                margin = dip(5)
            }
            swipeLayout(ctx) {
                id = R.id.item_list_swipe

                //bottomView（侧滑菜单）
                textView("删除") {
                    id = R.id.item_list_del
                    padding = dip(10)
                    gravity = Gravity.CENTER
                    textSize = 15f
                    textColorResource = R.color.white
                    backgroundColorResource = R.color.red_ff4d6b
                }.lparams(wrapContent, matchParent)

                //surfaceView（item显示内容）
                relativeLayout {
                    id = R.id.item_list_content_layout
                    padding = dip(10)
                    backgroundColorResource = R.color.white
                    textView("") {
                        id = R.id.item_list_name
                        textSize = 15f
                        textColorResource = R.color.gray_333333
                        gravity = Gravity.LEFT
                        maxLines = 1
                        ellipsize = TextUtils.TruncateAt.END
                        singleLine = true
                    }.lparams(matchParent, wrapContent) {
                        rightMargin = dip(5)
                    }
                    textView("1") {
                        id = R.id.item_list_num
                        textSize = 14f
                        textColorResource = R.color.gray_999999
                        maxLines = 2
                        ellipsize = TextUtils.TruncateAt.END
                    }.lparams(matchParent, wrapContent) {
                        below(R.id.item_list_name)
                        topMargin = dip(3)
                    }
                    checkBox {
                        id = R.id.item_list_done
                        isChecked = false
                    }.lparams {
                        alignParentRight()
                        centerVertically()
                        rightMargin = dip(10)
                    }
                }
            }
        }
    }
}