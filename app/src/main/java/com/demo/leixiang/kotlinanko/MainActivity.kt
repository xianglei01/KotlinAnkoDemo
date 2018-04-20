package com.demo.leixiang.kotlinanko

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import org.jetbrains.anko.*
import org.jetbrains.anko.sdk25.coroutines.onClick

class MainActivity : AppCompatActivity() {

    companion object {
        val ID_EDIT = 1
        val ID_BTN = 2
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        relativeLayout {
            var edit = editText {
                id = ID_EDIT
                hint = "demo"
                maxLines = 1
            }.lparams(matchParent, wrapContent) {
                topMargin = 50
                leftMargin = 20
                rightMargin = 20
            }

            var btn = button(R.string.click) {
                id = ID_BTN
                padding = 10
                backgroundResource = android.R.color.background_light
            }.lparams(matchParent, wrapContent) {
                margin = 20
                below(ID_EDIT)
            }.onClick {
                Toast.makeText(this@MainActivity, edit.text, Toast.LENGTH_SHORT).show()
            }
        }
    }
}
