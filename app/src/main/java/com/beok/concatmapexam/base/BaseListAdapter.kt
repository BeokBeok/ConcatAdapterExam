package com.beok.concatmapexam.base

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

open class BaseListAdapter<T, VDB : ViewDataBinding>(
    @LayoutRes private val layoutResourceID: Int,
    private val bindingID: Int,
    private val viewModels: Map<Int, ViewModel> = mapOf(),
    diffUtil: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseViewHolder<VDB>>(diffUtil) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<VDB> =
        BaseViewHolder(
            parent = parent,
            layoutResourceID = layoutResourceID,
            bindingID = bindingID,
            viewModels = viewModels,
        )

    override fun onBindViewHolder(holder: BaseViewHolder<VDB>, position: Int) {
        holder.bind(item = getItem(position))
    }

    override fun getItemViewType(position: Int): Int = layoutResourceID
}