package com.example.smartweather.viewModel

import android.content.Context
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartweather.R
import com.example.smartweather.data.ArtistServiceResponse
import com.example.smartweather.data.Datum
import com.example.smartweather.providers.MainService
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private var _listSongs = MutableLiveData<MutableList<Datum>>()

    var networkManager: MainService = MainService.Builder().build()
    var infoArtist = ArtistServiceResponse()
    var songSelected = Datum()
    var listSongs: LiveData<MutableList<Datum>> = _listSongs


    fun getArtistInfo(name: String, onServiceResponse: (isSuccess: Boolean) -> Unit) {
        viewModelScope.launch(Dispatchers.IO + getCoroutineExcHand()) {
            val response = networkManager.getArtistInfo(name)
            if (response.code() in 200..299) {

                val wrappedResponse: ArtistServiceResponse = response.body()!!

                if (wrappedResponse.data.isNullOrEmpty()) {
                    viewModelScope.launch(Dispatchers.Main) { onServiceResponse(false) }
                } else {
                    infoArtist = wrappedResponse
                    _listSongs.postValue(wrappedResponse.data)
                    viewModelScope.launch(Dispatchers.Main) { onServiceResponse(true) }
                }

            } else {
                viewModelScope.launch(Dispatchers.Main) { onServiceResponse(false) }
            }
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