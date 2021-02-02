package com.example.weather.domain.repository

import com.example.weather.data.entitiy.WeatherItemDB
import com.example.weather.data.source.retrofit.WeatherApiService
import com.example.weather.domain.entity.WeatherItem
import io.reactivex.Flowable

interface WeatherRepository {
    fun getAllWeather() : Flowable<List<WeatherItemDB>>
    fun getWeatherByCityName(weatherApiService: WeatherApiService, name: String): Flowable<WeatherItem>
    fun saveDBItem(item: WeatherItemDB)
}