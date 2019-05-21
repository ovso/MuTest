package io.github.ovso.mutest.view.ui.main.like

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel

class LikeViewModel : ViewModel() {

  private val _index = MutableLiveData<Int>()
  val text: LiveData<String> = Transformations.map(_index) {
    "Hello world from section: $it"
  }

  fun setIndex(index: Int) {
    _index.value = index
  }
}