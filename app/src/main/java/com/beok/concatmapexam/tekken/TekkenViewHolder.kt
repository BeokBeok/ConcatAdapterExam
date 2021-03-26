package com.beok.concatmapexam.tekken

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import com.beok.concatmapexam.BR
import com.beok.concatmapexam.R
import com.beok.concatmapexam.base.BaseAdapter
import com.beok.concatmapexam.base.BaseViewHolder
import com.beok.concatmapexam.databinding.ItemTekkenBinding
import com.beok.concatmapexam.databinding.ItemTekkenSummaryBinding

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