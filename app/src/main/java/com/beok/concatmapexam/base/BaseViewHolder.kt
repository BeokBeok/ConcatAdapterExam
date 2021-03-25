package com.beok.concatmapexam.base

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.RecyclerView

class BaseViewHolder<T>(
    parent: ViewGroup,
    @LayoutRes private val layoutResourceID: Int,
    private val bindingID: Int
) : RecyclerView.ViewHolder(
    LayoutInflater
        .from(parent.context)
        .inflate(layoutResourceID, parent, false)
) {

    private val binding: ViewDataBinding = DataBindingUtil.bind(itemView)!!

    fun bind(item: T, viewModels: Map<Int, ViewModel>) {
        binding.setVariable(bindingID, item)
        viewModels.keys.forEach {
            binding.setVariable(it, viewModels[it])
        }
        binding.executePendingBindings()
    }
}