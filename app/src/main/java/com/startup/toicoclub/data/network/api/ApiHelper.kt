package com.startup.toicoclub.data.network.api

import com.startup.toicoclub.data.network.model.WeatherData
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiHelper {

    @GET(ApiEndPoint.WEATHER)
    fun getWeatherByCountry(
        @Header("RapidAPIProject") a: String,
        @Header("X-RapidAPI-Host") b: String,
        @Header("X-RapidAPI-Key") c: String,
        @Query("q") name: String
    ): Observable<WeatherData>}