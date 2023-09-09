package com.example.weather.presenter

import com.example.weather.model.WeatherApi
import com.example.weather.model.WeatherModel
import com.example.weather.view.WeatherView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Presenter @Inject constructor(private val weatherApi: WeatherApi) {
    lateinit var weatherView: WeatherView

    fun getWeather() {
        weatherApi.getCurrentWeather().enqueue(object : Callback<WeatherModel> {
            override fun onResponse(call: Call<WeatherModel>, response: Response<WeatherModel>) {
                response.body()?.let {
                    weatherView.showWeather(it)
                }
            }

            override fun onFailure(call: Call<WeatherModel>, t: Throwable) {
                weatherView.showError(t.message.toString())
            }
        })
    }

    fun attachView(weatherView: WeatherView) {
        this.weatherView = weatherView
    }
}