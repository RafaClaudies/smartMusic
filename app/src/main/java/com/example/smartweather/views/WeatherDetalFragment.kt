package com.example.smartweather.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.smartweather.R
import com.example.smartweather.databinding.FragmentWeatherDetalBinding
import com.example.smartweather.viewModel.HomeViewModel


class WeatherDetalFragment : Fragment() {

    private val homeViewModel by activityViewModels<HomeViewModel>()
    private lateinit var bindingView: FragmentWeatherDetalBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindingView = FragmentWeatherDetalBinding.inflate(inflater, container, false)

        bindingView.apply {

            txv1.text = "Info 1"
            txv2.text = "Info 2"
            txv3.text = "Info 3"
            txv4.text = "Info 4"
            txv5.text = "Info 5"

            btnAccept.setOnClickListener {
                requireActivity().supportFragmentManager.popBackStack()
            }

        }

        return bindingView.root
    }

    companion object {

        @JvmStatic
        fun newInstance() = WeatherDetalFragment()
    }
}