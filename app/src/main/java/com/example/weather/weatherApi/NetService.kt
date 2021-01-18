package com.example.weather.weatherApi

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query



interface WeatherApiService {
    @GET("/data/2.5/weather")
    fun getWeatherFromCity(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): Call<WeatherItem>
}

