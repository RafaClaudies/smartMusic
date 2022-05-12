package com.example.smartweather.providers

import com.example.smartweather.data.WeatherResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface MainService {

    @GET("data/2.5/forecast/climate")
    suspend fun getWeather(
        @Query("lat") lat: Double,
        @Query("lon") lon: Double,
        @Query("appid") appId: String
    ): Response<WeatherResponse>

    class Builder() : BaseServiceBuilder<MainService>() {
        override fun build(): MainService {
            return mBuilder.build().create(MainService::class.java)
        }
    }

}