package com.example.weather.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.weather.domain.entity.WeatherItem
import com.example.weather.domain.usecase.GetAllWeatherUseCase
import com.example.weather.domain.usecase.GetWeatherByCityNameUseCase
import io.reactivex.Flowable


class MainViewModel(val getWeatherByCityNameUseCase: GetWeatherByCityNameUseCase,val getAllWeatherUseCase: GetAllWeatherUseCase) : ViewModel() {

    lateinit var currentWeatherItem : Flowable<WeatherItem>

    var allCitiesList = getAllWeatherUseCase.getAllWeather()

    private val _getCity = MutableLiveData<Boolean>()

    val getCity: LiveData<Boolean>
        get() = _getCity


    fun getCurrentWeatherItem(cityName: String) {
        currentWeatherItem =  getWeatherByCityNameUseCase.getWeatherByCityName(cityName)
    }

    fun onClick() {
        _getCity.value = true
    }



    fun onObserverFinish() {
        _getCity.value = false
    }
}