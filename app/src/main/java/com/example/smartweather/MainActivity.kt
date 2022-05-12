package com.example.smartweather

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.airbnb.lottie.LottieDrawable
import com.example.smartweather.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var bindingView : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bindingView = DataBindingUtil.setContentView(this, R.layout.activity_main)

        bindingView.apply {
            lifecycleOwner = this@MainActivity

            lottieLy.apply {
                imageAssetsFolder = "assets/"
                setAnimation("lottie.json")
                repeatCount = LottieDrawable.INFINITE
                playAnimation()
            }


        }
    }
}