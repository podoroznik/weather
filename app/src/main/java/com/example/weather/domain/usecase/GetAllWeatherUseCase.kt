package com.example.weather.domain.usecase

import com.example.weather.domain.entity.WeatherItem
import com.example.weather.domain.repository.WeatherRepository
import io.reactivex.Flowable

class GetAllWeatherUseCase (val repository: WeatherRepository){
    fun getAllWeather(): Flowable<List<WeatherItem>> {
        return repository.getAllWeather()
    }
}