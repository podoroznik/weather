package com.example.weather.domain.entity

import com.example.weather.utils.ProjectConstants.EMPTY_STRING

data class WeatherItem(
    var temp: Double = 0.0,
    var tempMax: Double = 0.0,
    var tempMin : Double = 0.0 ,
    var cityName : String = EMPTY_STRING
)