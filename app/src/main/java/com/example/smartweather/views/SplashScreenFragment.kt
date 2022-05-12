package com.example.smartweather.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.airbnb.lottie.LottieDrawable
import com.example.smartweather.R
import com.example.smartweather.databinding.FragmentSplashScreenBinding
import com.example.smartweather.viewModel.HomeViewModel


class SplashScreenFragment : Fragment() {

    private val homeViewModel by activityViewModels<HomeViewModel>()
    private lateinit var bindingView: FragmentSplashScreenBinding


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindingView = FragmentSplashScreenBinding.inflate(inflater, container, false)

        bindingView.apply {

            lottieLy.apply {
                imageAssetsFolder = "assets/"
                setAnimation("lottie.json")
                repeatCount = LottieDrawable.INFINITE
                playAnimation()
            }
        }

        return bindingView.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = SplashScreenFragment()
    }
}