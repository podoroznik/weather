package com.example.weather.domain.usecase

import com.example.weather.domain.entity.WeatherItem
import com.example.weather.domain.repository.WeatherRepository
import com.example.weather.data.source.retrofit.WeatherApiService
import io.reactivex.Flowable

class GetWeatherByCityNameUseCase(val repository: WeatherRepository,val weatherApiService: WeatherApiService) {
    fun getWeatherByCityName(name: String): Flowable<WeatherItem> {
        return repository.getWeatherByCityName(weatherApiService,name)
    }
}