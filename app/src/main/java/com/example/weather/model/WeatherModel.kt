package com.example.weather.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

data class WeatherModel(
    var main: MainModel
) : Serializable

data class MainModel(
    var temp: Double,
    @SerializedName("temp_min")
    var min: Double,
    @SerializedName("temp_max")
    var max: Double,
    var humidity: Int
) : Serializable

