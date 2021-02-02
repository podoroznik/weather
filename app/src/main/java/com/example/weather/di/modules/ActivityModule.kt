package com.example.weather.di.modules

import android.content.Context
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.data.repository.WeatherRepositoryImpl
import com.example.weather.data.source.database.WeatherDatabase
import com.example.weather.data.source.database.WeatherDatabaseDao
import com.example.weather.domain.repository.WeatherRepository
import com.example.weather.ui.recyclerView.WeatherRecyclerViewAdapter
import dagger.Module
import dagger.Provides


@Module
class ActivityModule(val context: Context) {

    @Provides
    fun provideRecyclerViewAdapter(): WeatherRecyclerViewAdapter{
        return WeatherRecyclerViewAdapter()
    }

    @Provides
    fun provideLinearLayoutManager(context: Context): LinearLayoutManager{
        return LinearLayoutManager(context).apply {
            reverseLayout = true
            stackFromEnd = true
        }
    }

     @Provides
     fun provideContext(): Context {
         return context
     }

    @Provides
    fun provideRepository(weatherDatabaseDao: WeatherDatabaseDao,context: Context) : WeatherRepository{
        return WeatherRepositoryImpl(weatherDatabaseDao,context)
    }

    @Provides
    fun provideDatabase(context: Context): WeatherDatabaseDao {
        return WeatherDatabase.getInstance(context).dao
    }


}