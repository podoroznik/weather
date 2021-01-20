package com.example.weather.ui

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.weather.R
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.di.components.DaggerMainViewModelComponent

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        val dagger =  DaggerMainViewModelComponent.builder().build()
        super.onCreate(savedInstanceState)
        val factory  = dagger.getMainViewModelFactory()

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this,
                R.layout.activity_main
            )



        val viewModel = ViewModelProvider(this,factory).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        viewModel.getCity.observe(this, Observer {
            if (it == true) {
                viewModel.getCurrentWeatherItem(
                    binding.cityEditText.text.toString(),
                    getString(R.string.api_key)
                )
                viewModel.onObserverFinish()
            }
        })

        viewModel.currentWeatherItem.observe(this, Observer {
            binding.tempText.text = it.main.temp.toString()
        })

        viewModel.onFailStatus.observe(this, Observer {
            if (it == true) {
                val toast =
                    Toast.makeText(this, getString(R.string.toast_fail_text), Toast.LENGTH_LONG)
                toast.show()
                viewModel.onFailToastShown()
            }
        })

        viewModel.onWrongCity.observe(this, Observer {
            if (it == true) {
                val toast =
                    Toast.makeText(this, getString(R.string.toast_wrong_city), Toast.LENGTH_LONG)
                toast.show()
                viewModel.onWrongCityToastShown()
            }
        })
    }
}