package com.example.weather

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query


//https://api.openweathermap.org/data/2.5/weather?appid={API key}&lat=42.882004&lon=74.582748&units=metric
interface WeatherApi {

    @GET("data/2.5/weather")
    fun getCurrentWeather(
        @Query("lon") lon: Double = 74.582748,
        @Query("lat") lat: Double = 42.882004,
        @Query("units") units: String = "metric",
        @Query("appid") key: String = "1dc20eff-917c-439d-8858-42e8a8e79a97"
    ): Call<WeatherModel>
}