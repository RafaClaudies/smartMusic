package com.example.smartweather.data

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Artist {
    @SerializedName("id")
    @Expose
    var id: Int? = 0

    @SerializedName("name")
    @Expose
    var name: String? = ""

    @SerializedName("link")
    @Expose
    var link: String? = ""

    @SerializedName("picture")
    @Expose
    var picture: String? = ""

    @SerializedName("picture_small")
    @Expose
    var pictureSmall: String? = ""

    @SerializedName("picture_medium")
    @Expose
    var pictureMedium: String? = ""

    @SerializedName("picture_big")
    @Expose
    var pictureBig: String? = ""

    @SerializedName("picture_xl")
    @Expose
    var pictureXl: String? = ""

    @SerializedName("tracklist")
    @Expose
    var tracklist: String? = ""

    @SerializedName("type")
    @Expose
    var type: String? = ""
}