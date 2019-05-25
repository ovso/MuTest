package io.github.ovso.mutest.ui.like

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import io.github.ovso.mutest.App
import io.github.ovso.mutest.api.model.Item
import io.github.ovso.mutest.ui.search.adapter.ItemViewModel.RxBusEventLike
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy

class LikeViewModel : ViewModel() {

  val itemLiveData = MutableLiveData<Item>()
  private val compositeDisposable = CompositeDisposable()

  init {
    toRxBusObservable()
  }

  private fun toRxBusObservable() {
    compositeDisposable.add(
      App.rxBus.toObservable().subscribeBy {
        if (it is RxBusEventLike) {
          itemLiveData.value = it.item
        }
      }
    )
  }

  override fun onCleared() {
    super.onCleared()
    compositeDisposable.clear()
  }
}