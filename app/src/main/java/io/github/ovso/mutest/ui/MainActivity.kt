package io.github.ovso.mutest.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import io.github.ovso.mutest.R.array
import io.github.ovso.mutest.R.layout
import kotlinx.android.synthetic.main.activity_main.tabs
import kotlinx.android.synthetic.main.activity_main.viewpager

class MainActivity : AppCompatActivity() {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)
    setContentView(layout.activity_main)
    viewpager.adapter =
      MainPagerAdapter(
        resources.getStringArray(array.main_tabs),
        supportFragmentManager
      )
    tabs.setupWithViewPager(viewpager)
  }
}