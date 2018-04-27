package com.demo.leixiang.kotlinanko.edit

import android.content.Context
import android.view.View
import com.demo.leixiang.kotlinanko.R
import org.jetbrains.anko.*

/**
 * Created by lei.xiang on 2018/4/24.
 */
class EditView : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        verticalLayout {
            editText {
                id = R.id.edit_title
                textSize = 16f
                textColorResource = R.color.gray_333333
                padding = dip(15)
                hintResource = R.string.edit_name_hint
                backgroundResource = 0
                maxLines = 1
                singleLine = true
            }.lparams(matchParent, wrapContent)

            view {
                backgroundColorResource = R.color.green_6fff00
            }.lparams(matchParent, 1) {
                leftMargin = dip(12)
            }

            editText {
                id = R.id.edit_content
                textSize = 16f
                textColorResource = R.color.gray_333333
                padding = dip(15)
                hintResource = R.string.edit_content_hint
                backgroundResource = 0
            }.lparams(matchParent, wrapContent)
        }
    }
}