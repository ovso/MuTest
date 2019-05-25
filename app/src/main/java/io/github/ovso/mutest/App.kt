package io.github.ovso.mutest

import android.app.Application
import io.github.ovso.mutest.utils.RxBus
import timber.log.Timber
import timber.log.Timber.DebugTree

class App : Application() {
  companion object {
    val rxBus = RxBus()
  }

  override fun onCreate() {
    super.onCreate()
    if (BuildConfig.DEBUG) {
      Timber.plant(DebugTree())
    }
  }
}