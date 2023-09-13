package com.example.weather

import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weather.databinding.ActivityMainBinding
import com.yandex.mapkit.Animation
import com.yandex.mapkit.MapKitFactory
import com.yandex.mapkit.geometry.Point
import com.yandex.mapkit.map.CameraPosition
import com.yandex.mapkit.map.InputListener
import com.yandex.mapkit.map.MapObjectTapListener
import com.yandex.mapkit.mapview.MapView
import com.yandex.runtime.image.ImageProvider
import com.yandex.runtime.ui_view.ViewProvider
import javax.inject.Inject


class MainActivity : AppCompatActivity(R.layout.activity_main), InputListener {

    private val binding: ActivityMainBinding by viewBinding()
    private val TARGET_LOCATION = Point(42.882004, 74.582748)

    @Inject
    lateinit var api: WeatherApi

    private val placemarkTapListener = MapObjectTapListener { _, point ->
        Toast.makeText(
            this@MainActivity,
            "Tapped the point(${point.longitude},${point.latitude}",
            Toast.LENGTH_SHORT
        ).show()
        true
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MapKitFactory.initialize(this)

        binding.mapview.map.move(
            CameraPosition(TARGET_LOCATION, 14.0f, 0.0f, 0.0f),
            Animation(Animation.Type.SMOOTH, 5f),
            null
        )

        val imageProvider = ImageProvider.fromResource(this, R.drawable.ic_launcher_background)
        val placemark =
            binding.mapview.map.mapObjects.addPlacemark(Point(42.882004, 74.582748), imageProvider)

        placemark.addTapListener(placemarkTapListener)

        binding.mapview.map.addInputListener(this)
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

    override fun onMapTap(p0: com.yandex.mapkit.map.Map, p1: Point) {
        val basePoiImageView = ImageView(this).apply {
            setImageResource(com.google.android.material.R.drawable.ic_keyboard_black_24dp) // icon is vector
        }
        binding.mapview.map.mapObjects.addPlacemark(p1, ViewProvider(basePoiImageView))
    }

    override fun onMapLongTap(p0: com.yandex.mapkit.map.Map, p1: Point) {
        Toast.makeText(this@MainActivity, "ok", Toast.LENGTH_SHORT).show()
    }
}

