package com.beok.concatmapexam.banner

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BannerViewModel @Inject constructor() : ViewModel() {

    private val _banner = MutableLiveData<List<Banner>>()
    val banner: LiveData<List<Banner>> get() = _banner

    fun fetch() {
        _banner.value = listOf(
            Banner(
                id = 1,
                imageUrl = "http://mimg.segye.com/content/image/2016/01/07/20160107500520.jpg"
            )
        )
    }
}