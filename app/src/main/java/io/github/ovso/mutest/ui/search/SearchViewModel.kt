package io.github.ovso.mutest.ui.search

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import io.github.ovso.mutest.api.SearchRequest
import io.github.ovso.mutest.api.model.Item
import io.github.ovso.mutest.repository.byPage.MyPageKeyedDataSourceFactory
import io.reactivex.disposables.CompositeDisposable

class SearchViewModel : ViewModel() {
  private val compositeDisposable = CompositeDisposable()
  val textChangedObField = ObservableField<String>()
  private val searchRequest = SearchRequest()
  private val pageSize = 10
  val removeLiveData = MutableLiveData<Boolean>()
  var pagedList: LiveData<PagedList<Item>>? = null

  init {
    fetchList()
  }

  private fun fetchList() {
    val config =
      PagedList.Config.Builder().setPageSize(pageSize).setInitialLoadSizeHint(pageSize * 2)
        .setEnablePlaceholders(
          false
        ).build()

    val dataSourceFactory =
      MyPageKeyedDataSourceFactory(compositeDisposable, searchRequest, textChangedObField)

    pagedList = LivePagedListBuilder<Int, Item>(
      dataSourceFactory,
      config
    ).build()
  }

  fun onSearchClick() {
    pagedList?.value?.dataSource?.invalidate()
  }

  override fun onCleared() {
    super.onCleared()
    compositeDisposable.clear()
  }

  fun onRemoveClick() {
    textChangedObField.set("")
    removeLiveData.value = true
  }
}