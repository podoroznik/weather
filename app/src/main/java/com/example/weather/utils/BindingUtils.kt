package com.example.weather.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.example.weather.R

@BindingAdapter("app:set_temp")
fun setTemp(textView: TextView,temp: Double){
    textView.text = textView.context.getString(R.string.temp) + temp.toString()
}

@BindingAdapter("app:set_min_temp")
fun setMinTemp(textView: TextView,temp: Double){
    textView.text = textView.context.getString(R.string.min_temp) + temp.toString()
}
@BindingAdapter("app:set_max_temp")
fun setMaxTemp(textView: TextView,temp: Double){
    textView.text = textView.context.getString(R.string.max_temp) + temp.toString()
}

@BindingAdapter("app:set_city_name")
fun setCityName(textView: TextView,name: String){
    textView.text = textView.context.getString(R.string.city) + name
}