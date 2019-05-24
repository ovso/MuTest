package io.github.ovso.mutest.repository.byPage

import androidx.databinding.ObservableField
import androidx.paging.PageKeyedDataSource
import io.github.ovso.mutest.api.SearchRequest
import io.github.ovso.mutest.api.model.Item
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.functions.Consumer
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import timber.log.Timber

class MyPageKeyedDataSource(
  private val compositeDisposable: CompositeDisposable,
  private val searchRequest: SearchRequest,
  private val txtChangeObField: ObservableField<String>
) :
  PageKeyedDataSource<Int, Item>() {
  override fun loadInitial(
    params: LoadInitialParams<Int>,
    callback: LoadInitialCallback<Int, Item>
  ) {
    Timber.d("loadInitial")
    val query = txtChangeObField.get()
    val currentPage = 1
    val nextPage = currentPage + 1
    query?.let {
      if (it.isNotEmpty()) {
        compositeDisposable.add(
          searchRequest.search(query, currentPage)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(Consumer {
              callback.onResult(it.items, null, nextPage)
            })
        )
      }
    }
  }

  override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
    Timber.d("loadAfter key = ${params.key}")
    val currentPage = params.key;
    val nextPage = currentPage + 1
    val query = txtChangeObField.get()
    query?.let {
      if (it.isNotEmpty()) {
        compositeDisposable.add(
          searchRequest.search(query, currentPage)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread()).subscribeBy(
              onError = {
                Timber.e(it)
              }, onSuccess = {
                callback.onResult(it.items, nextPage)
              }
            )
        )
      }
    }
  }

  override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Item>) {
    // Do nothing
  }

}