package com.beok.concatadapterexam

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("srcWithGlide")
fun srcWithGlide(imageView: ImageView, url: String?) {
    if (url == null) return
    Glide
        .with(imageView)
        .load(url)
        .into(imageView)
}
