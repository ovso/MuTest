package io.github.ovso.mutest.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.github.ovso.mutest.R
import io.github.ovso.mutest.databinding.FragmentSearchBinding
import io.github.ovso.mutest.ui.search.adapter.SearchAdapter
import kotlinx.android.synthetic.main.fragment_search.button_search_del
import kotlinx.android.synthetic.main.fragment_search.edittext_search_query
import kotlinx.android.synthetic.main.fragment_search.recyclerview_search

class SearchFragment : Fragment() {

  private lateinit var viewModel: SearchViewModel
  private val adapter = SearchAdapter()
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = ViewModelProviders.of(this).get(SearchViewModel::class.java)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val binding = inflateDataBinding(inflater, container)
    binding.viewModel = viewModel
    return binding.root
  }

  private fun inflateDataBinding(
    inflater: LayoutInflater,
    container: ViewGroup?
  ) = DataBindingUtil.inflate<FragmentSearchBinding>(
    inflater,
    R.layout.fragment_search,
    container,
    false
  )

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    setupRev()
    obvPages()
    button_search_del.setOnClickListener {
      edittext_search_query.text.clear()
      viewModel.onRemoveClick()
    }
  }

  private fun obvPages() {
    viewModel.pagedList?.observe(this, Observer {
      adapter.submitList(it)
    })
    viewModel.removeLiveData.observe(this, Observer {
      if (it) {
        adapter.submitList(null)
        adapter.notifyDataSetChanged()
        viewModel.removeLiveData.value = false
      }
    })
  }

  private fun setupRev() {
    recyclerview_search.adapter = adapter
  }

  companion object {
    @JvmStatic
    fun newInstance() = SearchFragment()
  }

}