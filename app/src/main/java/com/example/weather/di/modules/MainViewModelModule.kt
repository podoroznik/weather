package com.example.weather.di.modules

import com.example.weather.MainViewModelFactory
import com.example.weather.weatherApi.WeatherApiService
import dagger.Module
import dagger.Provides


@Module
class MainViewModelModule() {

    @Provides
    fun provideMainViewModelFactory(weatherApiService: WeatherApiService): MainViewModelFactory{
        return MainViewModelFactory(weatherApiService)
    }

}