package com.example.weather.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.weather.domain.usecase.GetAllWeatherUseCase
import com.example.weather.domain.usecase.GetWeatherByCityNameUseCase

class MainViewModelFactory(
    val getWeatherByCityNameUseCase: GetWeatherByCityNameUseCase,
    val getAllWeatherUseCase: GetAllWeatherUseCase
) : ViewModelProvider.Factory {
    @Suppress("unchecked_cast")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(getWeatherByCityNameUseCase,getAllWeatherUseCase) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}