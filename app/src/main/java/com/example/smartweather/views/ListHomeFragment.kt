package com.example.smartweather.views

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.view.ViewGroup
import android.view.inputmethod.EditorInfo
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartweather.databinding.FragmentListHomeBinding
import com.example.smartweather.viewModel.HomeViewModel
import com.example.smartweather.views.adapter.WeatherAdapter


class ListHomeFragment : Fragment() {

    private val homeViewModel by activityViewModels<HomeViewModel>()
    private lateinit var bindingView: FragmentListHomeBinding

    @SuppressLint("ClickableViewAccessibility")
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        bindingView = FragmentListHomeBinding.inflate(inflater, container, false)

        bindingView.apply {

            editQuery.setOnEditorActionListener { _, actionId, _ ->
                if (actionId == EditorInfo.IME_ACTION_DONE) {
                    homeViewModel.getArtistInfo(editQuery.text.toString()) {
                        onServiceResponse(it)
                    }
                    true
                } else false
            }

            editQuery.setOnTouchListener(OnTouchListener { _, event ->
                val DRAWABLE_RIGHT = 2
                if (event.action == MotionEvent.ACTION_UP) {
                    if (event.rawX >= editQuery.right - editQuery.compoundDrawables[DRAWABLE_RIGHT].bounds.width()) {
                        homeViewModel.getArtistInfo(editQuery.text.toString()) {
                            onServiceResponse(it)
                        }
                        return@OnTouchListener true
                    }
                }
                false
            })




        }

        return bindingView.root
    }

    private fun onServiceResponse(flag: Boolean) {
        bindingView.apply {
            if (flag) {
                txtFailed.visibility = View.GONE
                rvHome.apply {
                    visibility = View.VISIBLE
                    layoutManager = LinearLayoutManager(requireContext())
                    adapter = WeatherAdapter(homeViewModel.infoArtist.data!!) {
                        homeViewModel.songSelected = it
                        homeViewModel.replaceFragment(requireContext(), WeatherDetalFragment.newInstance(), "WeatherDetalFragment")
                    }
                }
            } else {
                rvHome.visibility = View.GONE
                txtFailed.visibility = View.VISIBLE
            }
        }
    }

    companion object {
        @JvmStatic
        fun newInstance() = ListHomeFragment()
    }
}