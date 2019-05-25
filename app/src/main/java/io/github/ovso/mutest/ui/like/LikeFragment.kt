package io.github.ovso.mutest.ui.like

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import io.github.ovso.mutest.R
import io.github.ovso.mutest.databinding.FragmentLikeBinding
import io.github.ovso.mutest.ui.like.adapter.LikeAdapter
import kotlinx.android.synthetic.main.fragment_like.recyclerview_like

class LikeFragment : Fragment() {
  private val adapter = LikeAdapter()
  private lateinit var viewModel: LikeViewModel
  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = ViewModelProviders.of(this).get(LikeViewModel::class.java)
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val binding = provideBinding(inflater, container)
    binding.viewModel = viewModel
    return binding.root
  }

  fun provideBinding(inflater: LayoutInflater, container: ViewGroup?) =
    DataBindingUtil.inflate<FragmentLikeBinding>(inflater, R.layout.fragment_like, container, false)

  override fun onActivityCreated(savedInstanceState: Bundle?) {
    super.onActivityCreated(savedInstanceState)
    viewModel.itemLiveData.observe(this, Observer {
      adapter.items.add(it)
      adapter.notifyDataSetChanged()
    })

    setupRev()
  }

  private fun setupRev() {
    recyclerview_like.adapter = adapter
  }

  companion object {
    fun newInstance() = LikeFragment()
  }
}