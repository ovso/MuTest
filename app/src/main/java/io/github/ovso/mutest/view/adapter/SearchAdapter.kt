package io.github.ovso.mutest.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import io.github.ovso.mutest.R
import io.github.ovso.mutest.api.model.Item
import io.github.ovso.mutest.view.adapter.SearchAdapter.SearchViewHolder
import kotlinx.android.extensions.LayoutContainer

class SearchAdapter() : PagedListAdapter<Item, SearchViewHolder>(DIFF_CALLBACK) {

  companion object {
    private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Item>() {
      override fun areItemsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
      override fun areContentsTheSame(oldItem: Item, newItem: Item) = oldItem == newItem
    }
  }

  override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
    SearchViewHolder.create(parent)

  override fun onBindViewHolder(holder: SearchViewHolder, position: Int) {
  }

  class SearchViewHolder(override val containerView: View?) : RecyclerView.ViewHolder(
    containerView!!
  ), LayoutContainer {

    companion object {
      fun create(parent: ViewGroup) = SearchViewHolder(
        LayoutInflater.from(parent.context).inflate(
          R.layout.item_main,
          parent,
          false
        )
      )
    }
  }
}