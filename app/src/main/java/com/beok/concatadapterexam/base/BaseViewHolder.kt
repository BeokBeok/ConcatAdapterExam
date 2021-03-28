package com.beok.concatadapterexam.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

open class BaseViewHolder<VDB : ViewDataBinding>(
    parent: ViewGroup,
    @LayoutRes private val layoutResourceID: Int,
    private val bindingID: Int,
    private val viewModels: Map<Int, ViewModel> = mapOf()
) : RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(layoutResourceID, parent, false)
) {

    protected val binding: VDB = DataBindingUtil.bind(itemView)!!

    open fun bind(item: Any?) {
        if (item == null) return
        binding.setVariable(bindingID, item)
        viewModels.keys.forEach {
            binding.setVariable(it, viewModels[it])
        }
        binding.executePendingBindings()
    }
}