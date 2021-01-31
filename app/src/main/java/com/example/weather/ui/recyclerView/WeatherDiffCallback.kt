package com.example.weather.ui.recyclerView

import androidx.recyclerview.widget.DiffUtil
import com.example.weather.domain.entity.WeatherItem

class WeatherDiffCallback : DiffUtil.ItemCallback<WeatherItem>(){
    override fun areItemsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: WeatherItem, newItem: WeatherItem): Boolean {
        return oldItem.cityName == newItem.cityName
    }

}