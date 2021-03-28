package com.beok.concatadapterexam.tekken

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.beok.concatadapterexam.BR
import com.beok.concatadapterexam.R
import com.beok.concatadapterexam.base.BaseAdapter
import com.beok.concatadapterexam.base.BaseViewHolder
import com.beok.concatadapterexam.databinding.ItemTekkenBinding
import com.beok.concatadapterexam.databinding.ItemTekkenSummaryBinding

class TekkenViewHolder(
    parent: ViewGroup,
    @LayoutRes private val layoutResourceID: Int,
    bindingID: Int,
) : BaseViewHolder<ItemTekkenSummaryBinding>(
    parent = parent,
    layoutResourceID = layoutResourceID,
    bindingID = bindingID,
) {

    override fun bind(item: Any?) {
        super.bind(item)

        binding.rvCharacterContent.adapter = BaseAdapter<ItemTekkenBinding>(
            layoutResourceID = R.layout.item_tekken,
            bindingID = BR.content
        ).apply {
            replaceItemList(binding.tekken?.contentList)
            notifyItemRangeChanged(0, binding.tekken?.contentList?.size ?: 0)
        }
    }
}