package io.github.ovso.mutest.binding

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

object ItemBinding {
  @JvmStatic
  @BindingAdapter("image_url")
  fun loadImage(imageView: ImageView, url: String) {
    Glide.with(imageView.context).load(url).into(imageView)
  }
}