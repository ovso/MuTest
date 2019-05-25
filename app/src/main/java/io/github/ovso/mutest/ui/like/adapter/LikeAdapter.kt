package io.github.ovso.mutest.ui.like.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.ovso.mutest.api.model.Item

class LikeAdapter : RecyclerView.Adapter<LikeViewHolder>() {
  val items = mutableListOf<Item>()
  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = LikeViewHolder.create(parent)

  override fun getItemCount() = items.size

  override fun onBindViewHolder(holder: LikeViewHolder, position: Int) {
    holder.bindTo(items[position])
  }

}