package com.demo.leixiang.kotlinanko.addtodo

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.RelativeLayout
import android.widget.TextView
import com.daimajia.swipe.SwipeLayout
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.base.adapter.BaseRecycleAdapter
import com.demo.leixiang.kotlinanko.data.Item
import com.demo.leixiang.kotlinanko.home.TodoCallback
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * created by xianglei
 * 2018/12/26 18:53
 */
class TodoAdapter(private var context: Context, list: List<Item>?) : BaseRecycleAdapter<Item, TodoAdapter.ViewHolder>(list) {

    private var callBack: TodoCallback<Item>? = null

    fun setOnDelListener(callback: TodoCallback<Item>) {
        this.callBack = callback
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, item: Item?) {
        holder.swipeLayout?.showMode = SwipeLayout.ShowMode.PullOut
        holder.txtName?.text = item?.name
        holder.txtNum?.text = item?.number
        holder.checkDone?.isChecked = item?.isDone ?: false
        holder.checkDone?.setOnCheckedChangeListener { buttonView, isChecked ->
            item?.isDone = isChecked
            callBack?.change(item)
        }
        holder.btnDel?.onClick {
            callBack?.del(item)
        }
        holder.contentLayout?.onClick {
            listener?.onItemClick(position, item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(TodoItemView.createItemView(context))
    }

    inner class ViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
        var swipeLayout = view?.find<SwipeLayout>(R.id.item_list_swipe)
        var contentLayout = view?.find<RelativeLayout>(R.id.item_list_content_layout)
        var txtName = view?.find<TextView>(R.id.item_list_name)
        var txtNum = view?.find<TextView>(R.id.item_list_num)
        var checkDone = view?.find<CheckBox>(R.id.item_list_done)
        var btnDel = view?.find<TextView>(R.id.item_list_del)
    }
}