package com.example.people.view.adapter

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("loadBadge")
fun loadBadge(imageView: ImageView, url: String?){
    Glide.with(imageView.context)
        .load(url)
        .into(imageView)
}