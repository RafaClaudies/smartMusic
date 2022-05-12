package com.example.smartweather.data

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

class WeatherResponse {

    @SerializedName("cod")
    @Expose
    var cod : String = ""

    @SerializedName("message")
    @Expose
    var message : String = ""
}