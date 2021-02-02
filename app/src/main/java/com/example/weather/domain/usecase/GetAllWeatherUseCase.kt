package com.example.weather.domain.usecase

import com.example.weather.data.entitiy.WeatherItemDB
import com.example.weather.domain.repository.WeatherRepository
import io.reactivex.Flowable

class GetAllWeatherUseCase (val repository: WeatherRepository){
    fun getAllWeather(): Flowable<List<WeatherItemDB>> {
        return repository.getAllWeather()
    }
}