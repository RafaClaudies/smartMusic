package com.example.smartweather.views

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartweather.R
import com.example.smartweather.databinding.FragmentListHomeBinding
import com.example.smartweather.viewModel.HomeViewModel
import com.example.smartweather.views.adapter.WeatherAdapter


class ListHomeFragment : Fragment() {

    private val homeViewModel by activityViewModels<HomeViewModel>()
    private lateinit var bindingView: FragmentListHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        bindingView = FragmentListHomeBinding.inflate(inflater, container, false)

        bindingView.apply {

            rvHome.apply {

                layoutManager = LinearLayoutManager(requireContext())

                val listTest = arrayListOf<String>()
                listTest.add("")
                listTest.add("")
                listTest.add("")
                listTest.add("")
                listTest.add("")

                adapter = WeatherAdapter(listTest) {
                    homeViewModel.replaceFragment(requireContext(), WeatherDetalFragment.newInstance(), "WeatherDetalFragment")
                }
            }

        }

        return bindingView.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListHomeFragment()
    }
}