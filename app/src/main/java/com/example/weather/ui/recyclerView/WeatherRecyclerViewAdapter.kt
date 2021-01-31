package com.example.weather.ui.recyclerView

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.databinding.WeatherItemBinding
import com.example.weather.domain.entity.WeatherItem

class WeatherRecyclerViewAdapter :
    ListAdapter<WeatherItem, WeatherRecyclerViewAdapter.ViewHolder>(WeatherDiffCallback()) {

    class ViewHolder private constructor(val binding: WeatherItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(item: WeatherItem){
            binding.weatherItem = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val inflater = LayoutInflater.from(parent.context)
                val binding = WeatherItemBinding.inflate(inflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val weatherItem = getItem(position)
        holder.bind(weatherItem)
    }
}