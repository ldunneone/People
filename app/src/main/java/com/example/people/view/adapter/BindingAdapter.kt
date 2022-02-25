package com.example.people.view.adapter

import android.graphics.Color
import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide


@BindingAdapter("loadBadge")
fun loadBadge(imageView: ImageView, url: String?){
    Glide.with(imageView.context)
        .load(url)
        .into(imageView)
}

@BindingAdapter("setBackgroundColor")
fun setBackgroundColor(textView: TextView, favouriteColor: String){
    textView.setBackgroundColor(Color.parseColor(favouriteColor))
}