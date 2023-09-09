package com.example.weather

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weather.databinding.ActivityMainBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.mapview.MapView
import javax.inject.Inject


class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()
    private val TARGET_LOCATION = Point(42.882004, 74.582748)

    @Inject
    lateinit var api: WeatherApi

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        binding.mapview.map.move(
//            CameraPosition(Point(55.751574, 37.573856), 11.0f, 0.0f, 0.0f),
//            Animation(Animation.Type.SMOOTH, 0f),
//            null
//        )

//        binding.mapview.setOnClickListener {
//            Toast.makeText(
//                this,
//                "${(it as MapView).focusPoint.x} , : , ${it.focusPoint.y}",
//                Toast.LENGTH_SHORT
//            ).show()
//        }

        binding.mapview.getMap().move(
            CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 5f),
            null
        )
    }

    override fun onStop() {
        binding.mapview.onStop()
        MapKitFactory.getInstance().onStop()
        super.onStop()
    }

    override fun onStart() {
        super.onStart()
        MapKitFactory.getInstance().onStart()
        binding.mapview.onStart()
    }
}

//package com.example.weatherapp
//
//import android.Manifest
//import android.app.Activity
//import android.content.pm.PackageManager
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import androidx.core.app.ActivityCompat
//import by.kirich1409.viewbindingdelegate.viewBinding
//import com.example.weatherapp.databinding.ActivityMainBinding
//import com.yandex.mapkit.Animation
//import com.yandex.mapkit.MapKitFactory
//import com.yandex.mapkit.geometry.Point
//import com.yandex.mapkit.map.CameraPosition
//
//
//class MainActivity : AppCompatActivity(R.layout.activity_main) {
//
//    private val binding: ActivityMainBinding by viewBinding()
//    private val TARGET_LOCATION = Point(42.882004, 74.582748)
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
//        binding.mapview.getMap().move(
//            CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
//            Animation(Animation.Type.SMOOTH, 5f),
//            null
//        )
//    }
//    override fun onStop() {
//        binding.mapview.onStop()
//        MapKitFactory.getInstance().onStop()
//        super.onStop()
//    }
//
//    override fun onStart() {
//        super.onStart()
//        MapKitFactory.getInstance().onStart()
//        binding.mapview.onStart()
//    }
//}