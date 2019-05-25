package io.github.ovso.mutest.ui.like.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.ovso.mutest.R
import io.github.ovso.mutest.api.model.Item
import io.github.ovso.mutest.databinding.ItemAllBinding
import io.github.ovso.mutest.ui.search.adapter.ItemViewModel

class LikeViewHolder(private val binding: ItemAllBinding) :
  RecyclerView.ViewHolder(binding.root) {

  fun bindTo(item: Item?) {
    binding.viewModel = ItemViewModel(item)
    binding.lottieItemLike.visibility = View.INVISIBLE
  }

  companion object {
    fun create(parent: ViewGroup) =
      LikeViewHolder(
        DataBindingUtil.inflate(
          LayoutInflater.from(parent.context),
          R.layout.item_all,
          parent,
          false
        )
      )
  }

}