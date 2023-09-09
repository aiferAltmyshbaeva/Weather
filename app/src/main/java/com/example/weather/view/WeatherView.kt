package com.example.weather.view

import com.example.weather.model.WeatherModel

interface WeatherView {

    fun showWeather(weatherModel: WeatherModel)
    fun showError(message: String)

}