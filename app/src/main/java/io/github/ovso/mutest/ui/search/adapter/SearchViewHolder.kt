package io.github.ovso.mutest.ui.search.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.ovso.mutest.R
import io.github.ovso.mutest.api.model.Item
import io.github.ovso.mutest.databinding.ItemAllBinding

class SearchViewHolder(private val binding: ItemAllBinding) :
  RecyclerView.ViewHolder(binding.root) {
  fun bindTo(item: Item?) {
    binding.item = item

  }

  companion object {
    fun create(parent: ViewGroup) =
      SearchViewHolder(
        DataBindingUtil.inflate(
          LayoutInflater.from(parent.context),
          R.layout.item_all,
          parent,
          false
        )
      )
  }

}