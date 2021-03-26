package com.beok.concatmapexam.base

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

class BaseAdapter<T, VDB : ViewDataBinding>(
    @LayoutRes private val layoutResourceID: Int,
    private val bindingID: Int
) : RecyclerView.Adapter<BaseViewHolder<T, VDB>>() {

    private val itemList = mutableListOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T, VDB> =
        BaseViewHolder(
            parent = parent,
            layoutResourceID = layoutResourceID,
            bindingID = bindingID
        )

    override fun onBindViewHolder(holder: BaseViewHolder<T, VDB>, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun replaceItemList(items: List<T>?) {
        if (items == null) return

        itemList.run {
            clear()
            addAll(items)
        }
    }
}