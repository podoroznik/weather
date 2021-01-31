package com.example.weather.utils

import com.example.weather.domain.entity.WeatherItem
import data.entitiy.WeatherItemDB
import data.entitiy.WeatherItemJson

fun WeatherItemJson.convertFromJSONItemToDBItem(): WeatherItemDB {
    val weatherItemDB = WeatherItemDB()
    weatherItemDB.temp = this.main.temp
    weatherItemDB.tempMin = this.main.temp_min
    weatherItemDB.tempMax = this.main.temp_max
    weatherItemDB.name = this.name
    return weatherItemDB
}

fun WeatherItemJson.convertFromJSONItemToItem(): WeatherItem {
    return WeatherItem(
        main.temp,
        main.temp_max,
        main.temp_min,
        name
    )
}

fun WeatherItem.convertFromItemToDBItem(): WeatherItemDB{
    val weatherItemDB = WeatherItemDB()
    weatherItemDB.temp = this.temp
    weatherItemDB.tempMin = this.tempMin
    weatherItemDB.tempMax = this.tempMax
    weatherItemDB.name = this.cityName
    return weatherItemDB
}