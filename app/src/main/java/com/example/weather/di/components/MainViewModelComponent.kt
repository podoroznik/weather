package com.example.weather.di.components

import com.example.weather.di.modules.ActivityModule
import com.example.weather.di.modules.MainViewModelModule
import com.example.weather.di.modules.NetworkModule
import com.example.weather.di.modules.UseCaseModule
import com.example.weather.di.scopes.ActivityScope
import com.example.weather.ui.MainActivity
import dagger.Component
    
@ActivityScope
@Component(modules = [MainViewModelModule::class,NetworkModule::class,ActivityModule::class,UseCaseModule::class])
interface MainViewModelComponent {
    fun inject(mainActivity: MainActivity)
}