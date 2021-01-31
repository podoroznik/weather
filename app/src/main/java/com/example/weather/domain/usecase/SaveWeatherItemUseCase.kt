package com.example.weather.domain.usecase

import com.example.weather.domain.repository.WeatherRepository
import data.entitiy.WeatherItemDB

class SaveWeatherItemUseCase(val repository: WeatherRepository) {
    fun saveWeatherItem(weatherItemDB : WeatherItemDB){
        repository.saveDBItem(weatherItemDB)
    }
}