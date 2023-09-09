package com.example.weather.model

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("data/2.5/weather")
    fun getCurrentWeather(
        @Query("appid") key: String = "36cbf21e77603d1848c9293fd5e5ba31",
        @Query("lon") lon: Double = 74.582748,
        @Query("lat") lat: Double = 42.882004,
        @Query("units") units: String = "metric"
    ): Call<WeatherModel>
}