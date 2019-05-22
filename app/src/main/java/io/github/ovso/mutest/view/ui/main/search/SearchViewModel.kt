package io.github.ovso.mutest.view.ui.main.search

import android.text.Editable
import android.text.TextWatcher
import androidx.lifecycle.ViewModel
import timber.log.Timber

class SearchViewModel : ViewModel() {
  fun doSearch() {
    Timber.d("doSearch")
  }

  fun onTextChanged(s: CharSequence, start: Int, count: Int) {
    Timber.d("onTextChanged($s, $start, $count)")
  }

  val onTextWatcher = object : TextWatcher {
    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
      Timber.d("doSearch")
    }

    override fun afterTextChanged(s: Editable?) {
      Timber.d("doSearch")
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
      Timber.d("doSearch")
    }
  }

}