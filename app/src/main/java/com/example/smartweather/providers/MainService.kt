package com.example.smartweather.providers

import retrofit2.http.GET
import retrofit2.http.Query

interface MainService {

    @GET("data/2.5/forecast/climate")
    fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String
    )

    class Builder() : BaseServiceBuilder<MainService>() {
        override fun build(): MainService {
            return mBuilder.build().create(MainService::class.java)
        }
    }

}