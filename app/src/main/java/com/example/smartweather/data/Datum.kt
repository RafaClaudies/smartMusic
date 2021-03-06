package com.example.smartweather.data

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName


class Datum {
    @SerializedName("id")
    @Expose
    var id: Int? = null

    @SerializedName("readable")
    @Expose
    var readable: Boolean? = null

    @SerializedName("title")
    @Expose
    var title: String? = null

    @SerializedName("title_short")
    @Expose
    var titleShort: String? = null

    @SerializedName("title_version")
    @Expose
    var titleVersion: String? = null

    @SerializedName("link")
    @Expose
    var link: String? = null

    @SerializedName("duration")
    @Expose
    var duration: Int? = null

    @SerializedName("rank")
    @Expose
    var rank: Int? = null

    @SerializedName("explicit_lyrics")
    @Expose
    var explicitLyrics: Boolean? = null

    @SerializedName("explicit_content_lyrics")
    @Expose
    var explicitContentLyrics: Int? = null

    @SerializedName("explicit_content_cover")
    @Expose
    var explicitContentCover: Int? = null

    @SerializedName("preview")
    @Expose
    var preview: String? = null

    @SerializedName("md5_image")
    @Expose
    var md5Image: String? = null

    @SerializedName("artist")
    @Expose
    var artist: Artist? = null

    @SerializedName("album")
    @Expose
    var album: Album? = null

    @SerializedName("type")
    @Expose
    var type: String? = null
}