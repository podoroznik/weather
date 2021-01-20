package com.example.weather.di.modules

import com.example.weather.di.scopes.ActivityScope
import com.example.weather.ui.MainViewModelFactory
import com.example.weather.weatherApi.WeatherApiService
import dagger.Module
import dagger.Provides


@Module
class MainViewModelModule() {
    @ActivityScope
    @Provides
    fun provideMainViewModelFactory(weatherApiService: WeatherApiService): MainViewModelFactory {
        return MainViewModelFactory(weatherApiService)
    }

}