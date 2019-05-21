package io.github.ovso.mutest.view.ui.main.like

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import io.github.ovso.mutest.R

class LikeFragment : Fragment() {

  private lateinit var viewModel: LikeViewModel

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    viewModel = ViewModelProviders.of(this).get(LikeViewModel::class.java).apply {
      setIndex(arguments?.getInt(ARG_SECTION_NUMBER) ?: 1)
    }
  }

  override fun onCreateView(
    inflater: LayoutInflater, container: ViewGroup?,
    savedInstanceState: Bundle?
  ): View? {
    val root = inflater.inflate(R.layout.fragment_like, container, false)
    return root
  }

  companion object {
    private const val ARG_SECTION_NUMBER = "section_number"
    @JvmStatic
    fun newInstance(sectionNumber: Int): LikeFragment {
      return LikeFragment().apply {
        arguments = Bundle().apply {
          putInt(ARG_SECTION_NUMBER, sectionNumber)
        }
      }
    }
  }
}