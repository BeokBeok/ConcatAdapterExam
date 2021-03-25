package com.beok.concatmapexam.base

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

class BaseAdapter<T>(
    @LayoutRes private val layoutResourceID: Int,
    private val bindingID: Int,
    private val viewModels: Map<Int, ViewModel>,
    diffUtil: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseViewHolder<T>>(diffUtil) {

    private val itemList = mutableListOf<T>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<T> =
        BaseViewHolder(
            parent = parent,
            layoutResourceID = layoutResourceID,
            bindingID = bindingID
        )

    override fun onBindViewHolder(holder: BaseViewHolder<T>, position: Int) {
        holder.bind(item = itemList[position], viewModels = viewModels)
    }

    override fun getItemViewType(position: Int): Int = layoutResourceID

    override fun getItemCount(): Int = itemList.size
}