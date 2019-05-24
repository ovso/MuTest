package io.github.ovso.mutest.ui.search.adapter

import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import io.github.ovso.mutest.api.model.Item

class SearchAdapter() : PagedListAdapter<Item, SearchViewHolder>(DIFF_CALLBACK) {

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    SearchViewHolder.create(parent)

  override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
    holder.bindTo(getItem(position))
  }

  companion object {
    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
      override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem

      override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
    }
  }
}