package data.repository

import android.annotation.SuppressLint
import android.content.Context
import com.example.weather.R
import com.example.weather.domain.entity.WeatherItem
import com.example.weather.domain.repository.WeatherRepository
import com.example.weather.utils.convertFromJSONItemToItem
import data.entitiy.WeatherItemDB
import data.source.database.WeatherDatabaseDao
import data.source.retrofit.WeatherApiService
import io.reactivex.Completable
import io.reactivex.Flowable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

class WeatherRepositoryImpl(val weatherDatabaseDao: WeatherDatabaseDao, val context: Context) :
    WeatherRepository {
    override fun getAllWeather(): Flowable<List<WeatherItem>> {
        return weatherDatabaseDao.getAllData().flatMap { Flowable.fromIterable(it) }.map {
            WeatherItem(it.temp, it.tempMax, it.tempMin, it.name)
        }.toList().toFlowable()
    }

    @SuppressLint("CheckResult")
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