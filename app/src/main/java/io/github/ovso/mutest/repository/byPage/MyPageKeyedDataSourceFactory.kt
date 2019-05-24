package io.github.ovso.mutest.repository.byPage

import androidx.databinding.ObservableField
import androidx.paging.DataSource
import io.github.ovso.mutest.api.SearchRequest
import io.github.ovso.mutest.api.model.Item
import io.reactivex.disposables.CompositeDisposable

class MyPageKeyedDataSourceFactory(
  private val compositeDisposable: CompositeDisposable,
  private val searchRequest: SearchRequest,
  private val textChangeObField: ObservableField<String>
) :
  DataSource.Factory<Int, Item>() {
  override fun create() = MyPageKeyedDataSource(
    compositeDisposable,
    searchRequest,
    textChangeObField
  )
}