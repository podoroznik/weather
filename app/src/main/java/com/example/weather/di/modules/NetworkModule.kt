package com.example.weather.di.modules

import com.example.weather.di.scopes.ActivityScope
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import data.source.retrofit.WeatherApiService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {

    @ActivityScope
    @Provides
    fun provideWeatherService(retrofit: Retrofit): WeatherApiService {
        return retrofit.create(
            WeatherApiService::class.java
        )
    }

    @ActivityScope
    @Provides
    fun provideRetrofit(gson : GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org")
            .addConverterFactory(gson)
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    @ActivityScope
    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()


}