package com.example.weather.di.modules

import com.example.weather.weatherApi.WeatherApiService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@Module
class NetworkModule {


    @Provides
    fun provideWeatherService(retrofit: Retrofit): WeatherApiService {
        return retrofit.create(
            WeatherApiService::class.java
        )
    }

    @Provides
    fun provideRetrofit(gson : GsonConverterFactory): Retrofit {
        return Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org")
            .addConverterFactory(gson)
            .build()
    }


    @Provides
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()


}