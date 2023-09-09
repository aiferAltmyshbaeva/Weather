package com.example.weather

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.model.WeatherModel
import com.example.weather.presenter.Presenter
import com.example.weather.view.WeatherView
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity(R.layout.activity_main), WeatherView {

    private val binding: ActivityMainBinding by viewBinding()

    @Inject
    lateinit var presenter: Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        presenter.attachView(this)
        initClickers()
    }

    private fun initClickers() {
        binding.btnWeather.setOnClickListener {
            presenter.getWeather()
        }
    }

    override fun showWeather(weatherModel: WeatherModel) {
//        Log.e("ololo", "showWeather: $weatherModel")
        binding.tvTemp.text = "${weatherModel.main?.temp.toString()}°"
        binding.tvMin.text  = " мин: ${weatherModel.main?.min.toString()}°"
        binding.tvMax.text = "макс: ${weatherModel.main?.max.toString()}°"
        binding.tvHumidity.text = "влажность: ${weatherModel.main?.humidity.toString()}"
    }

    override fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}

