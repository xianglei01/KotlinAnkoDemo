package com.demo.leixiang.kotlinanko.home

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.demo.leixiang.kotlinanko.R
import com.demo.leixiang.kotlinanko.base.BaseRecycleAdapter
import com.demo.leixiang.kotlinanko.data.Memorandum
import com.demo.leixiang.kotlinanko.utils.DateUtil
import org.jetbrains.anko.find

/**
 * Created by lei.xiang on 2018/4/24.
 */
class MemorandumAdapter(private var context: Context, list: List<Memorandum>?) : BaseRecycleAdapter<Memorandum, MemorandumAdapter.ViewHolder>(list) {

    override fun onBindViewHolder(holder: ViewHolder, position: Int, item: Memorandum?) {
        holder.txtTitle?.text = item?.title
        holder.txtContent?.text = item?.content
        holder.txtDate?.text = DateUtil.millisToDate(item?.time)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(ItemView.createMemorandumView(context))
    }

    inner class ViewHolder(view: View?) : RecyclerView.ViewHolder(view) {
        var txtTitle = view?.find<TextView>(R.id.item_list_title)
        var txtContent = view?.find<TextView>(R.id.item_list_content)
        var txtDate = view?.find<TextView>(R.id.item_list_date)
    }
}
