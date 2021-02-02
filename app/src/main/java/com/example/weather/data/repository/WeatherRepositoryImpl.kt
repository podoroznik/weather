package com.example.weather.data.repository

import android.content.Context
import com.example.weather.R
import com.example.weather.data.entitiy.WeatherItemDB
import com.example.weather.data.source.database.WeatherDatabaseDao
import com.example.weather.data.source.retrofit.WeatherApiService
import com.example.weather.domain.entity.WeatherItem
import com.example.weather.domain.repository.WeatherRepository
import com.example.weather.utils.convertFromJSONItemToItem
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherRepositoryImpl(val weatherDatabaseDao: WeatherDatabaseDao, val context: Context) :
    WeatherRepository {
    override fun getAllWeather(): Flowable<List<WeatherItemDB>> {
        return weatherDatabaseDao.getAllData()
    }

    override fun getWeatherByCityName(
        weatherApiService: WeatherApiService,
        name: String
    ): Flowable<WeatherItem> {
        return weatherApiService.getWeatherFromCity(name, context.getString(R.string.api_key))
            .subscribeOn(Schedulers.newThread())
            .observeOn(AndroidSchedulers.mainThread())
            .toFlowable()
            .map { it.convertFromJSONItemToItem() }
    }

    override fun saveDBItem(item: WeatherItemDB) {
        Completable.fromAction { weatherDatabaseDao.insert(item) }
            .subscribeOn(Schedulers.io()).subscribe()
    }
}