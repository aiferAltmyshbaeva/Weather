package com.example.weather

import android.app.Application
import com.yandex.mapkit.MapKitFactory
import dagger.hilt.android.HiltAndroidApp


@HiltAndroidApp
class App : Application(){

    override fun onCreate() {
        super.onCreate()
        MapKitFactory.setApiKey("1dc20eff-917c-439d-8858-42e8a8e79a97")
    }

}