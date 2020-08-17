package com.example.autoparsingjson.viewModel

import android.app.Application
import androidx.annotation.NonNull
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.autoparsingjson.repository.apicall.getWeatherData
import kotlinx.coroutines.*
import java.util.*


class MainActivityViewModel(@NonNull application: Application) : AndroidViewModel(application) {



    private var _display = MutableLiveData<String>()
    val display: LiveData<String>
        get() = _display;
    fun getWeather(){
       getWeatherData().sendRequest(getApplication(),_display )


    }

    /**
     * Return the application.
     */




}