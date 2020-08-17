package com.example.autoparsingjson.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.autoparsingjson.R
import com.example.autoparsingjson.viewModel.MainActivityViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    lateinit var viewModel: MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //set viewModel

        viewModel = ViewModelProvider(this).get(MainActivityViewModel::class.java)
        //UI
        setUI()
        //


        setViewModelObserver()
    }

    private fun setUI() {

        button.setOnClickListener() {
            viewModel.getWeather()
        }
    }

    private fun setViewModelObserver() {
        viewModel.display.observe(this, Observer {
            textView.text = it

        })
    }
}