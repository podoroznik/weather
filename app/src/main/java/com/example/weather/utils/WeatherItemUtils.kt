package com.example.weather.utils

import com.example.weather.data.entitiy.WeatherItemDB
import com.example.weather.data.entitiy.WeatherItemJson
import com.example.weather.domain.entity.WeatherItem

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

fun WeatherItemDB.convertFromItemDBToItem(): WeatherItem{
    val weatherItem = WeatherItem()
    weatherItem.temp = this.temp
    weatherItem.tempMin = this.tempMin
    weatherItem.tempMax = this.tempMax
    weatherItem.cityName= this.name
    return weatherItem
}


fun WeatherItem.convertFromItemToDBItem(): WeatherItemDB{
    val weatherItemDB = WeatherItemDB()
    weatherItemDB.temp = this.temp
    weatherItemDB.tempMin = this.tempMin
    weatherItemDB.tempMax = this.tempMax
    weatherItemDB.name = this.cityName
    return weatherItemDB
}


fun  List<WeatherItemDB>.convertFromListItemToListDBItem(): MutableList<WeatherItem>? {
    val list1 = mutableListOf<WeatherItem>()
    for(item in this){
        list1.add(item.convertFromItemDBToItem())
    }
    return list1
}