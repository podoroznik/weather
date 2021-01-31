package com.example.weather.di.modules

import com.example.weather.domain.repository.WeatherRepository
import com.example.weather.domain.usecase.GetAllWeatherUseCase
import com.example.weather.domain.usecase.GetWeatherByCityNameUseCase
import com.example.weather.domain.usecase.SaveWeatherItemUseCase
import dagger.Module
import dagger.Provides
import data.source.retrofit.WeatherApiService

@Module
class UseCaseModule {
    @Provides
    fun provideGetAllWeatherUseCase(repository: WeatherRepository): GetAllWeatherUseCase {
        return GetAllWeatherUseCase(repository)
    }

    @Provides
    fun provideGetWeatherByCityNameUseCase(repository: WeatherRepository,weatherApiService: WeatherApiService): GetWeatherByCityNameUseCase {
        return GetWeatherByCityNameUseCase(repository,weatherApiService)
    }

    @Provides
    fun provideSaveWeatherItemUseCase(repository: WeatherRepository): SaveWeatherItemUseCase {
        return SaveWeatherItemUseCase(repository)
    }
}