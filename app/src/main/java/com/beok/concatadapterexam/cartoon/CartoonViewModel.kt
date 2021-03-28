package com.beok.concatadapterexam.cartoon

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CartoonViewModel @Inject constructor() : ViewModel() {

    private val _cartoonList = MutableLiveData<List<Cartoon>>()
    val cartoonList: LiveData<List<Cartoon>> get() = _cartoonList

    fun fetch() {
        _cartoonList.value = listOf(
            Cartoon(
                imageURL = "https://i.pinimg.com/originals/11/a4/7b/11a47bbb62573cb1d38c0844a9eb8525.png",
                name = "보노보노1"
            ),
            Cartoon(
                imageURL = "https://i.pinimg.com/originals/11/a4/7b/11a47bbb62573cb1d38c0844a9eb8525.png",
                name = "보노보노2"
            ),
            Cartoon(
                imageURL = "https://i.pinimg.com/originals/11/a4/7b/11a47bbb62573cb1d38c0844a9eb8525.png",
                name = "보노보노3"
            ),
            Cartoon(
                imageURL = "https://i.pinimg.com/originals/11/a4/7b/11a47bbb62573cb1d38c0844a9eb8525.png",
                name = "보노보노4"
            ),
            Cartoon(
                imageURL = "https://i.pinimg.com/originals/11/a4/7b/11a47bbb62573cb1d38c0844a9eb8525.png",
                name = "보노보노5"
            )
        )
    }
}