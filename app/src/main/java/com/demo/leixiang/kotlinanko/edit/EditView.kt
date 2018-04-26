package com.demo.leixiang.kotlinanko.edit

import android.content.Context
import android.view.View
import com.demo.leixiang.kotlinanko.R
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by lei.xiang on 2018/4/24.
 */
class EditView : AnkoComponent<Context> {

    override fun createView(ui: AnkoContext<Context>): View = with(ui) {
        verticalLayout {
            relativeLayout {
                textView(R.string.edit_title) {
                    id = R.id.edit_title
                    textSize = 18f
                    textColorResource = R.color.gray_333333
                }.lparams {
                    centerInParent()
                }

                imageView(R.mipmap.ic_done) {
                    id = R.id.edit_title_btn
                    onClick {
                        //提交
                        toast("提交")
                    }
                }.lparams {
                    rightMargin = dip(10)
                    alignParentRight()
                    centerVertically()
                }

                view {
                    backgroundColorResource = R.color.gray_999999
                }.lparams(matchParent, dip(1)) {
                    alignParentBottom()
                }
            }.lparams(matchParent, dip(45))

            editText {
                id = R.id.edit_name
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