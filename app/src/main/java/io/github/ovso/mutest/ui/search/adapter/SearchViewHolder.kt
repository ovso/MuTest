package io.github.ovso.mutest.ui.search.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.github.ovso.mutest.R.layout
import io.github.ovso.mutest.api.model.Item
import kotlinx.android.extensions.LayoutContainer
import timber.log.Timber

class SearchViewHolder(override val containerView: View?) :
  RecyclerView.ViewHolder(containerView!!), LayoutContainer {

  fun bindTo(item: Item?) {
    Timber.d("bindTo(${item?.login})")
  }

  companion object {
    fun create(parent: ViewGroup) = SearchViewHolder(
      LayoutInflater.from(parent.context).inflate(
        layout.item_main,
        parent,
        false
      )
    )
  }

}