package com.beok.concatadapterexam.tekken

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TekkenViewModel @Inject constructor() : ViewModel() {

    private val _character = MutableLiveData<List<Tekken>>()
    val character: LiveData<List<Tekken>> get() = _character

    fun fetch() {
        _character.value = listOf(
            Tekken(
                id = 0,
                contentList = listOf(
                    Content(
                        imageURL = "https://t1.daumcdn.net/cfile/blog/161AE6484E5198391C",
                        name = "진"
                    ),
                    Content(
                        imageURL = "https://i.pinimg.com/originals/8d/15/73/8d157393e5b286bfb343169ddecb36ae.jpg",
                        name = "브라이언"
                    ),
                    Content(
                        imageURL = "https://images.kbench.com/kbench/article/2020_03/k208709p1n1.jpg",
                        name = "파쿰람"
                    )
                )
            )
        )
    }
}