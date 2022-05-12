package com.example.smartweather.viewModel

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartweather.R
import com.example.smartweather.providers.MainService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    var networkManager: MainService = MainService.Builder().build()

    fun getWeather(onServiceResponse: () -> Unit) {
        viewModelScope.launch(Dispatchers.IO + getCoroutineExcHand()) {
            val response = networkManager.getWeather(35.01, 129.01, "")

            onServiceResponse()

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


    fun replaceFragment(context: Context, fragment: Fragment?, tag: String) {
        if (fragment != null) {
            val transaction = (context as AppCompatActivity).supportFragmentManager.beginTransaction()
            transaction.replace(R.id.main_container, fragment)
            if (tag != "") transaction.addToBackStack(tag)
            transaction.commit()
        }
    }

}