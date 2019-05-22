package io.github.ovso.mutest.view.ui.main

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import io.github.ovso.mutest.view.ui.main.like.LikeFragment
import io.github.ovso.mutest.view.ui.main.search.SearchFragment

class MainPagerAdapter(private var titles: Array<String>, fm: FragmentManager) :
  FragmentPagerAdapter(fm) {
  override fun getItem(position: Int) =
    when (position == 0) {
      true -> SearchFragment.newInstance()
      false -> LikeFragment.newInstance()
    }

  override fun getPageTitle(position: Int) = titles[position]

  override fun getCount() = titles.size
}