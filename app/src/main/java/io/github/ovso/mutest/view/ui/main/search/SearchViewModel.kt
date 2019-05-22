package io.github.ovso.mutest.view.ui.main.search

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import timber.log.Timber

class SearchViewModel : ViewModel() {
  val textChangeObField = ObservableField<String>()

  fun onSearchClick() {
    Timber.d("doSearch = ${textChangeObField.get()}")
  }

}