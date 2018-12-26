package com.demo.leixiang.kotlinanko.view

import android.content.Context
import android.text.InputType
import android.view.View
import com.demo.leixiang.kotlinanko.R
import org.jetbrains.anko.*

/**
 * created by xianglei
 * 2018/12/26 18:28
 */
class AddToDoView : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        verticalLayout {
            editText {
                id = R.id.edit_title
                textSize = 16f
                textColorResource = R.color.gray_333333
                padding = dip(15)
                hintResource = R.string.edit_add_name_hint
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
                inputType = InputType.TYPE_CLASS_NUMBER
                hintResource = R.string.edit_add_num_hint
                backgroundResource = 0
            }.lparams(matchParent, wrapContent)
        }
    }
}