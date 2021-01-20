package com.example.weather.di.components

import com.example.weather.di.modules.MainViewModelModule
import com.example.weather.di.modules.NetworkModule
import com.example.weather.di.scopes.ActivityScope
import com.example.weather.ui.MainViewModelFactory
import dagger.Component

@ActivityScope
@Component(modules = [MainViewModelModule::class,NetworkModule::class])
interface MainViewModelComponent {
    fun getMainViewModelFactory() : MainViewModelFactory
}