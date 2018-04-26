package com.demo.leixiang.kotlinanko.home

import android.content.Context
import android.text.TextUtils
import android.view.View
import com.demo.leixiang.kotlinanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.cardview.v7.cardView

/**
 * Created by lei.xiang on 2018/4/25.
 */
object ItemView {

    fun createMemorandumView(ctx: Context): View = with(ctx) {
        cardView {
            lparams(matchParent, wrapContent) {
                margin = dip(5)
            }
            relativeLayout {
                padding = dip(10)
                textView("无题") {
                    id = R.id.item_list_title
                    textSize = 15f
                    textColorResource = R.color.gray_333333
                }
                textView("不年假但是词汇量烧开后就及自己奇偶基金才无色差吧变得更积极你分红No猴后已和vow额范文芳范围肠胃访问哥哥范围分为非") {
                    id = R.id.item_list_content
                    textSize = 14f
                    textColorResource = R.color.gray_999999
                    maxLines = 2
                    ellipsize = TextUtils.TruncateAt.END
                }.lparams(matchParent, wrapContent) {
                    below(R.id.item_list_title)
                    topMargin = dip(3)
                }
                textView("2018.04.24") {
                    id = R.id.item_list_date
                    textSize = 14f
                    textColorResource = R.color.gray_aaaaaa
                }.lparams {
                    below(R.id.item_list_content)
                    alignParentRight()
                    topMargin = dip(3)
                }
            }
        }
    }

}