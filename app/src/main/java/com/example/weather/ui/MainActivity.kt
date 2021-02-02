package com.example.weather.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.weather.R
import com.example.weather.data.entitiy.WeatherItemDB
import com.example.weather.databinding.ActivityMainBinding
import com.example.weather.di.components.DaggerMainViewModelComponent
import com.example.weather.di.modules.ActivityModule
import com.example.weather.domain.usecase.SaveWeatherItemUseCase
import com.example.weather.ui.recyclerView.WeatherRecyclerViewAdapter
import com.example.weather.utils.convertFromItemToDBItem
import com.example.weather.utils.convertFromListItemToListDBItem
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var factory: MainViewModelFactory

    @Inject
    lateinit var saveWeatherItemUseCase: SaveWeatherItemUseCase

    @Inject
    lateinit var layoutManager: LinearLayoutManager

    @Inject
    lateinit var adapter: WeatherRecyclerViewAdapter

    private val disposeBag = CompositeDisposable()

    override fun onCreate(savedInstanceState: Bundle?) {
        DaggerMainViewModelComponent.builder().activityModule(ActivityModule(this)).build()
            .inject(this)
        super.onCreate(savedInstanceState)

        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(
                this,
                R.layout.activity_main
            )

        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = layoutManager

        val viewModel = ViewModelProvider(this, factory).get(MainViewModel::class.java)
        binding.viewModel = viewModel

        disposeBag.add(
            viewModel.allCitiesList.subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ list: List<WeatherItemDB> ->
                    adapter.addHeaderAndSubmitList(list.convertFromListItemToListDBItem())
                    Log.e("123", "123")
                }, {})
        )

        viewModel.getCity.observe(this, Observer {
            if (it == true) {
                viewModel.getCurrentWeatherItem(binding.cityEditText.text.toString())
                disposeBag.add(
                    viewModel.currentWeatherItem
                        .subscribe({
                            it.convertFromItemToDBItem().let {
                                saveWeatherItemUseCase.saveWeatherItem(it)
                                binding.tempText.text = it.temp.toString()
                            }
                            viewModel.allCitiesList = viewModel.getAllWeatherUseCase.getAllWeather()
                        }, {
                            val toast =
                                Toast.makeText(
                                    this,
                                    getString(R.string.toast_fail_text),
                                    Toast.LENGTH_LONG
                                )
                            toast.show()
                        })
                )
                viewModel.onObserverFinish()
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        disposeBag.dispose()
    }

}


