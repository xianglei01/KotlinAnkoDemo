package com.demo.leixiang.kotlinanko.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.base.adapter.BaseRecycleAdapter
import com.demo.leixiang.kotlinanko.data.Memorandum
import com.demo.leixiang.kotlinanko.listener.CallBack
import com.demo.leixiang.kotlinanko.utils.DateUtil
import org.jetbrains.anko.find
import org.jetbrains.anko.sdk25.coroutines.onClick

/**
 * Created by lei.xiang on 2018/4/24.
 */
class MemorandumAdapter(private var context: Context, list: List<Memorandum>?) : BaseRecycleAdapter<Memorandum, MemorandumAdapter.ViewHolder>(list) {

    private var callBack: CallBack<Memorandum>? = null

    fun setOnDelListener(action: (memorandum: Memorandum?) -> Unit) {
        callBack = object : CallBack<Memorandum> {
            override fun callBack(data: Memorandum?) {
                action(data)
            }
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int, item: Memorandum?) {
        holder.txtTitle?.text = item?.title
        holder.txtContent?.text = item?.content
        holder.txtDate?.text = DateUtil.millisToDate(item?.time)
        holder.btnDel?.onClick {
            callBack?.callBack(item)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(ItemView.createMemorandumView(context))
    }

    inner class ViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
        var txtTitle = view?.find<TextView>(R.id.item_list_title)
        var txtContent = view?.find<TextView>(R.id.item_list_content)
        var txtDate = view?.find<TextView>(R.id.item_list_date)
        var btnDel = view?.find<ImageView>(R.id.item_list_del)
    }
}
