package com.example.smartweather.data

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Album {
    @SerializedName("id")
    @Expose
    var id: Int? = 0

    @SerializedName("title")
    @Expose
    var title: String? = ""

    @SerializedName("cover")
    @Expose
    var cover: String? = ""

    @SerializedName("cover_small")
    @Expose
    var coverSmall: String? = ""

    @SerializedName("cover_medium")
    @Expose
    var coverMedium: String? = ""

    @SerializedName("cover_big")
    @Expose
    var coverBig: String? = ""

    @SerializedName("cover_xl")
    @Expose
    var coverXl: String? = ""

    @SerializedName("md5_image")
    @Expose
    var md5Image: String? = ""

    @SerializedName("tracklist")
    @Expose
    var tracklist: String? = ""

    @SerializedName("type")
    @Expose
    var type: String? = ""
}