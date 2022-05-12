package com.example.smartweather.providers

import com.example.smartweather.data.ArtistServiceResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {

    @GET("search")
    suspend fun getArtistInfo(@Query("q") artist: String): Response<ArtistServiceResponse>

    class Builder : BaseServiceBuilder<MainService>() {
        override fun build(): MainService {
            return mBuilder.build().create(MainService::class.java)
        }
    }

}