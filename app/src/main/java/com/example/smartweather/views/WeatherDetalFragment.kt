package com.example.smartweather.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import coil.load
import com.example.smartweather.R
import com.example.smartweather.databinding.FragmentWeatherDetalBinding
import com.example.smartweather.viewModel.HomeViewModel


class WeatherDetalFragment : Fragment() {

    private val homeViewModel by activityViewModels<HomeViewModel>()
    private lateinit var bindingView: FragmentWeatherDetalBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        bindingView = FragmentWeatherDetalBinding.inflate(inflater, container, false)

        bindingView.apply {

            val infoSong = homeViewModel.songSelected

            imgSong.load(infoSong.album?.coverMedium)

            txv1.text = "Titulo: ${infoSong.title}"
            txv2.text = "Artista: ${infoSong.artist?.name}"
            txv3.text = "Album: ${infoSong.album?.title}"

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