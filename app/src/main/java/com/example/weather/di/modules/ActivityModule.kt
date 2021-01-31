package com.example.weather.di.modules

import android.content.Context
import com.example.weather.domain.repository.WeatherRepository
import dagger.Module
import dagger.Provides
import data.repository.WeatherRepositoryImpl
import data.source.database.WeatherDatabase
import data.source.database.WeatherDatabaseDao


@Module
class ActivityModule(val context: Context) {
     @Provides
     fun provideContext(): Context {
         return context
     }

    @Provides
    fun provideRepository(weatherDatabaseDao: WeatherDatabaseDao,context: Context) : WeatherRepository{
        return WeatherRepositoryImpl(weatherDatabaseDao,context)
    }

    @Provides
    fun provideDatabase(context: Context): WeatherDatabaseDao {
        return WeatherDatabase.getInstance(context).dao
    }


}