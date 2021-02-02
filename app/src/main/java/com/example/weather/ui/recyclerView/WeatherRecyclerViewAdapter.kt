package com.example.weather.ui.recyclerView

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.weather.R
import com.example.weather.databinding.WeatherItemBinding
import com.example.weather.domain.entity.WeatherItem

private const val ITEM_VIEW_TYPE_HEADER = 0
private const val ITEM_VIEW_TYPE_ITEM = 1

class WeatherRecyclerViewAdapter :
    ListAdapter<DataItem, RecyclerView.ViewHolder>(WeatherDiffCallback()) {

    fun addHeaderAndSubmitList(list: List<WeatherItem>?) {
        val items = when (list) {
            null -> listOf(DataItem.Header)
            else ->  list.map { DataItem.WeatherItemClass(it) } + listOf(DataItem.Header)
        }
        submitList(items)
    }

    class HeaderViewHolder private constructor(view: View) : RecyclerView.ViewHolder(view){
        companion object{
            fun from(parent: ViewGroup) : HeaderViewHolder{
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.header,parent,false)
                return HeaderViewHolder(view)
            }
        }
    }

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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when(viewType){
            ITEM_VIEW_TYPE_ITEM -> ViewHolder.from(parent)
            ITEM_VIEW_TYPE_HEADER -> HeaderViewHolder.from(parent)
            else -> throw ClassCastException("Unknown type of class $viewType")
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DataItem.Header -> ITEM_VIEW_TYPE_HEADER
            is DataItem.WeatherItemClass -> ITEM_VIEW_TYPE_ITEM
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(holder){
            is ViewHolder ->{
                val weatherItem = getItem(position) as DataItem.WeatherItemClass
                holder.bind(weatherItem.weatherItem)
            }
        }
    }
}

sealed class DataItem {
    abstract val id : Long


    data class WeatherItemClass(val weatherItem: WeatherItem) : DataItem() {
        override val id = weatherItem.hashCode().toLong()
    }
    object Header: DataItem(){
        override val id = Long.MIN_VALUE
    }
}