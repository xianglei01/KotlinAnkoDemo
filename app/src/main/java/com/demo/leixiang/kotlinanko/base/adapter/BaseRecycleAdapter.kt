package com.demo.leixiang.kotlinanko.base.adapter

import android.support.v7.widget.RecyclerView
import com.demo.leixiang.kotlinanko.listener.OnItemClickListener
import org.jetbrains.anko.sdk25.coroutines.onClick


/**
 * Created by lei.xiang on 2018/4/25.
 */
abstract class BaseRecycleAdapter<T, E : RecyclerView.ViewHolder>(private var list: List<T>?) : RecyclerView.Adapter<E>() {

    open var listener: OnItemClickListener<T>? = null

    open fun setData(list: List<T>?) {
        this.list = list
        notifyDataSetChanged()
    }

    fun setOnItemClickListener(action: (Int, T?) -> Unit) {
        listener = object : OnItemClickListener<T> {
            override fun onItemClick(position: Int, item: T?) {
                action(position, item)
            }
        }
    }

    override fun onBindViewHolder(holder: E, position: Int) {
        var item = list?.get(position)
        onBindViewHolder(holder, position, item)
        holder.itemView.onClick {
            listener?.onItemClick(position, item)
        }
    }

    override fun getItemCount(): Int = list?.size ?: 0

    abstract fun onBindViewHolder(holder: E, position: Int, item: T?)
}