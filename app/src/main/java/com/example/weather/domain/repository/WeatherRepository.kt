package com.example.weather.domain.repository

import com.example.weather.domain.entity.WeatherItem
import data.entitiy.WeatherItemDB
import data.source.retrofit.WeatherApiService
import io.reactivex.Flowable

interface WeatherRepository {
    fun getAllWeather() : Flowable<List<WeatherItem>>
    fun getWeatherByCityName(weatherApiService: WeatherApiService, name: String): Flowable<WeatherItem>
    fun saveDBItem(item: WeatherItemDB)
}