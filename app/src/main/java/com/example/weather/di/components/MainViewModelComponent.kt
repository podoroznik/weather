package com.example.weather.di.components

import com.example.weather.MainViewModelFactory
import com.example.weather.di.modules.MainViewModelModule
import com.example.weather.di.modules.NetworkModule
import dagger.Component


@Component(modules = [MainViewModelModule::class,NetworkModule::class])
interface MainViewModelComponent {
    fun getMainViewModelFactory() : MainViewModelFactory
}