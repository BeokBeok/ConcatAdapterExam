package com.beok.concatadapterexam

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.DiffUtil
import com.beok.concatadapterexam.banner.BannerViewModel
import com.beok.concatadapterexam.base.BaseAdapter
import com.beok.concatadapterexam.base.BaseListAdapter
import com.beok.concatadapterexam.cartoon.Cartoon
import com.beok.concatadapterexam.cartoon.CartoonViewModel
import com.beok.concatadapterexam.databinding.ActivityMainBinding
import com.beok.concatadapterexam.databinding.ItemBannerBinding
import com.beok.concatadapterexam.databinding.ItemCartoonBinding
import com.beok.concatadapterexam.tekken.TekkenAdapter
import com.beok.concatadapterexam.tekken.TekkenViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val bannerViewModel by viewModels<BannerViewModel>()
    private val tekkenViewModel by viewModels<TekkenViewModel>()
    private val cartoonViewModel by viewModels<CartoonViewModel>()

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setupBinding()
        setupRecyclerView()
        showContent()
    }

    private fun setupRecyclerView() {
        val bannerAdapter = BaseAdapter<ItemBannerBinding>(
            layoutResourceID = R.layout.item_banner,
            bindingID = BR.banner
        ).apply {
            bannerViewModel.banner.observe(this@MainActivity, {
                replaceItemList(it)
                notifyItemInserted(0)
            })
        }
        val tekkenAdapter = TekkenAdapter(
            viewModels = mapOf(BR.vm to tekkenViewModel)
        ).apply {
            tekkenViewModel.character.observe(this@MainActivity, {
                replaceItemList(it)
                notifyItemInserted(0)
            })
        }
        val cartoonAdapter = BaseListAdapter<Cartoon, ItemCartoonBinding>(
            layoutResourceID = R.layout.item_cartoon,
            bindingID = BR.cartoon,
            diffUtil = object : DiffUtil.ItemCallback<Cartoon>() {
                override fun areItemsTheSame(oldItem: Cartoon, newItem: Cartoon): Boolean {
                    return oldItem.name == newItem.name
                }

                override fun areContentsTheSame(oldItem: Cartoon, newItem: Cartoon): Boolean {
                    return oldItem == newItem
                }
            }
        ).apply {
            cartoonViewModel.cartoonList.observe(this@MainActivity, {
                submitList(it)
            })
        }
        binding.rvMainContent.adapter =
            ConcatAdapter(listOf(bannerAdapter, tekkenAdapter, cartoonAdapter))
    }

    private fun setupBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
    }

    private fun showContent() {
        bannerViewModel.fetch()
        cartoonViewModel.fetch()
        tekkenViewModel.fetch()
    }
}