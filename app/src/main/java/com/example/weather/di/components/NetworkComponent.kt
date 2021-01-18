package com.example.weather.di.components

import androidx.appcompat.app.AppCompatActivity
import com.example.weather.di.modules.NetworkModule
import dagger.Component

@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun inject(activity: AppCompatActivity)
}