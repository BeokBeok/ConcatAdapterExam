package com.beok.concatmapexam.tekken

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import com.beok.concatmapexam.BR
import com.beok.concatmapexam.R
import com.beok.concatmapexam.base.BaseAdapter
import com.beok.concatmapexam.base.BaseViewHolder
import com.beok.concatmapexam.databinding.ItemTekkenSummaryBinding

class TekkenAdapter(
    @LayoutRes private val layoutResourceID: Int = R.layout.item_tekken_summary,
    private val bindingID: Int = BR.tekken,
    viewModels: Map<Int, ViewModel>
) : BaseAdapter<ItemTekkenSummaryBinding>(
    layoutResourceID = layoutResourceID,
    bindingID = bindingID,
    viewModels = viewModels
) {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): BaseViewHolder<ItemTekkenSummaryBinding> = TekkenViewHolder(
        parent = parent, layoutResourceID = layoutResourceID, bindingID = bindingID
    )
}