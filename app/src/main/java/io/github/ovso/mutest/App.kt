package io.github.ovso.mutest

import android.app.Application
import timber.log.Timber
import timber.log.Timber.DebugTree

class App : Application() {

  override fun onCreate() {
    super.onCreate()
    if (BuildConfig.DEBUG) {
      Timber.plant(DebugTree())
    }
  }
}