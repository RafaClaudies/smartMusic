package com.example.smartweather.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartweather.providers.MainService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var networkManager: MainService = MainService.Builder().build()

    fun getWeather() {
        viewModelScope.launch(Dispatchers.IO + getCoroutineExcHand()) {

        }
    }

    private fun getCoroutineExcHand(): CoroutineExceptionHandler {
        return CoroutineExceptionHandler { _, t ->
            run {
                t.printStackTrace()
                Log.e(
                    "ERROR_HANDLER",
                    "Error al consumir servicio -----------------------> ${t.message}"
                )
            }
        }
    }

}