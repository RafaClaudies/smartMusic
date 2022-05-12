package com.example.smartweather.views

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.smartweather.R
import com.example.smartweather.databinding.ActivityHomeBinding
import com.example.smartweather.viewModel.HomeViewModel

class HomeActivity : AppCompatActivity() {

    private val homeViewModel by lazy { ViewModelProvider(this).get(HomeViewModel::class.java) }
    lateinit var bindingView: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindingView = DataBindingUtil.setContentView(this, R.layout.activity_home)

        bindingView.apply {
            lifecycleOwner = this@HomeActivity
        }

    }
}