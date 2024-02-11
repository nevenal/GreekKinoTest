package com.example.greekkino

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class GreekKinoApp : Application() {

    companion object {
        var instance: GreekKinoApp? = null
    }

    override fun onCreate() {
        super.onCreate()
        instance = this
    }
}
