package com.recyclerviewdatabinding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object BindingUtil {
    @BindingAdapter("setImageUrl")
    @JvmStatic fun ImageView.setImageUrl(url: String) {
        Glide.with(this).load(url).into(this)
    }
}