package com.example.smartweather.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.example.smartweather.R
import com.example.smartweather.viewModel.HomeViewModel

class HomeActivity : AppCompatActivity() {

    private val homeViewModel by lazy { ViewModelProvider(this).get(HomeViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
    }
}