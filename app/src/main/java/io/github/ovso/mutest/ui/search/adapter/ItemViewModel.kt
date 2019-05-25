package io.github.ovso.mutest.ui.search.adapter

import android.view.View
import com.airbnb.lottie.LottieAnimationView
import io.github.ovso.mutest.App
import io.github.ovso.mutest.api.model.Item

class ItemViewModel(private val item: Item?) {

  val name: String?
    get() = item?.login
  val score: String?
    get() = item?.score?.toString()
  val avatar: String?
    get() = item?.avatar_url
  val progress: Float
    get() = if (item!!.like) 100f else 0f

  fun onLikeClick(v: View) {
    item?.let {
      if (!it.like) {
        it.like = true
        (v as? LottieAnimationView)?.playAnimation()
        App.rxBus.send(RxBusEventLike(it))
      }
    }
  }

  class RxBusEventLike(val item: Item)
}