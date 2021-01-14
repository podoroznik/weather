package com.example.weather.weatherApi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query


var retrofit = Retrofit.Builder()
    .baseUrl("http://api.openweathermap.org")
    .addConverterFactory(GsonConverterFactory.create())
    .build()


interface WeatherApiService {
    @GET("/data/2.5/weather")
    fun getWeatherFromCity(
        @Query("q") city: String,
        @Query("appid") apiKey: String,
        @Query("units") units: String = "metric"
    ): Call<WeatherItem>
}

object WeatherApi {
    val retrofitService: WeatherApiService by lazy {
        retrofit.create(
            WeatherApiService::class.java
        )
    }
}
