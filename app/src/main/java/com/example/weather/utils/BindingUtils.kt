package com.example.weather.utils

import android.widget.TextView
import androidx.databinding.BindingAdapter

@BindingAdapter("app:set_temp")
fun setTemp(textView: TextView,double: Double){
    textView.text = double.toString()
}