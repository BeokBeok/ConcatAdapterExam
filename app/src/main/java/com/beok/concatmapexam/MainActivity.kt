package com.beok.concatmapexam

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.ConcatAdapter
import androidx.recyclerview.widget.DiffUtil
import com.beok.concatmapexam.banner.Banner
import com.beok.concatmapexam.banner.BannerViewModel
import com.beok.concatmapexam.base.BaseAdapter
import com.beok.concatmapexam.base.BaseListAdapter
import com.beok.concatmapexam.cartoon.Cartoon
import com.beok.concatmapexam.cartoon.CartoonViewModel
import com.beok.concatmapexam.databinding.ActivityMainBinding
import com.beok.concatmapexam.databinding.ItemBannerBinding
import com.beok.concatmapexam.databinding.ItemCartoonBinding
import com.beok.concatmapexam.tekken.TekkenViewModel
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
        val bannerAdapter = BaseAdapter<Banner, ItemBannerBinding>(
            layoutResourceID = R.layout.item_banner,
            bindingID = BR.banner
        ).apply {
            bannerViewModel.banner.observe(this@MainActivity, {
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
            ConcatAdapter(listOf(bannerAdapter, cartoonAdapter))
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