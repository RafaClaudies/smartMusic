package com.example.smartweather.data

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class ArtistServiceResponse {
    @SerializedName("data")
    @Expose
    var data: List<Datum>? = null

    @SerializedName("total")
    @Expose
    var total: Int? = 0

    @SerializedName("next")
    @Expose
    var next: String? = ""
}