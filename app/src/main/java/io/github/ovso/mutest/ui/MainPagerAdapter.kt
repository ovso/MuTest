package io.github.ovso.mutest.ui

import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import io.github.ovso.mutest.ui.like.LikeFragment
import io.github.ovso.mutest.ui.search.SearchFragment

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