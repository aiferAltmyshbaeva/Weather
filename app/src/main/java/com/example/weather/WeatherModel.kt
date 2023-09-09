package com.example.weather

import com.google.gson.annotations.SerializedName

data class WeatherModel(
    var main: MainModel
)

data class MainModel(
    var temp: Double,
    @SerializedName("temp_min")
    var min: Double,
    @SerializedName("temp_max")
    var max: Double,
    var humidity: Int
)

