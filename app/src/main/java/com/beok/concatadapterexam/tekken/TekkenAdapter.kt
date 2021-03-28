package com.beok.concatadapterexam.tekken

import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModel
import com.beok.concatadapterexam.BR
import com.beok.concatadapterexam.R
import com.beok.concatadapterexam.base.BaseAdapter
import com.beok.concatadapterexam.base.BaseViewHolder
import com.beok.concatadapterexam.databinding.ItemTekkenSummaryBinding

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