package com.example.weather.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weather.weatherApi.WeatherApiService
import com.example.weather.weatherApi.WeatherItem
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response


class MainViewModel(val weatherApiService: WeatherApiService) : ViewModel() {
    val currentWeatherItem = MutableLiveData<WeatherItem>()

    private val _getCity = MutableLiveData<Boolean>()

    val getCity: LiveData<Boolean>
        get() = _getCity

    private val _onFailStatus = MutableLiveData<Boolean>()

    val onFailStatus: LiveData<Boolean>
        get() = _onFailStatus


    private val _onWrongCity = MutableLiveData<Boolean>()

    val onWrongCity: LiveData<Boolean>
        get() = _onWrongCity

    fun getCurrentWeatherItem(cityName: String, apiKey: String) {
        viewModelScope.launch {
            weatherApiService.getWeatherFromCity(
                cityName,
                apiKey
            ).enqueue(object : retrofit2.Callback<WeatherItem> {
                override fun onFailure(call: Call<WeatherItem>, t: Throwable) {
                    Log.i("getWeatherStatus", "fail")
                    _onFailStatus.value = true
                }

                override fun onResponse(
                    call: Call<WeatherItem>,
                    response: Response<WeatherItem>
                ) {
                    if (response.isSuccessful) {
                        currentWeatherItem.value = response.body()
                        Log.i("getWeatherStatus", "success")
                    } else {
                        _onWrongCity.value = true
                    }
                }
            })


        }
    }

    fun onClick() {
        _getCity.value = true
    }

    fun onFailToastShown() {
        _onFailStatus.value = false
    }

    fun onWrongCityToastShown() {
        _onWrongCity.value = false
    }

    fun onObserverFinish() {
        _getCity.value = false
    }
}