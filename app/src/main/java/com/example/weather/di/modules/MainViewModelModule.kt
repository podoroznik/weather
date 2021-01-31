package com.example.weather.di.modules

import com.example.weather.di.scopes.ActivityScope
import com.example.weather.domain.usecase.GetAllWeatherUseCase
import com.example.weather.domain.usecase.GetWeatherByCityNameUseCase
import com.example.weather.ui.MainViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MainViewModelModule() {
    @ActivityScope
    @Provides
    fun provideMainViewModelFactory(getAllWeatherUseCaseFactory: GetAllWeatherUseCase,getWeatherByCityNameUseCase: GetWeatherByCityNameUseCase): MainViewModelFactory {
        return MainViewModelFactory(getWeatherByCityNameUseCase,getAllWeatherUseCaseFactory)
    }

}