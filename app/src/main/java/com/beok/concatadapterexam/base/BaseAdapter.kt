package com.beok.concatadapterexam.base

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

open class BaseAdapter<VDB : ViewDataBinding>(
    @LayoutRes private val layoutResourceID: Int,
    private val bindingID: Int,
    private val viewModels: Map<Int, ViewModel> = mapOf()
) : RecyclerView.Adapter<BaseViewHolder<VDB>>() {

    private val itemList = mutableListOf<Any>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VDB> =
        BaseViewHolder(
            parent = parent,
            layoutResourceID = layoutResourceID,
            bindingID = bindingID,
            viewModels = viewModels
        )

    override fun onBindViewHolder(holder: BaseViewHolder<VDB>, position: Int) {
        holder.bind(itemList[position])
    }

    override fun getItemCount(): Int = itemList.size

    fun replaceItemList(items: List<Any>?) {
        if (items == null) return

        itemList.run {
            clear()
            addAll(items)
        }
    }
}