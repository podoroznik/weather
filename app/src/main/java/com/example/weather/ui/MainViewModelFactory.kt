package com.example.weather.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weather.weatherApi.WeatherApiService

class MainViewModelFactory(
    val weatherApiService: WeatherApiService
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(weatherApiService) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}