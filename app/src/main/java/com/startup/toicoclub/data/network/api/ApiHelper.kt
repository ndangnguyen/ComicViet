package com.startup.toicoclub.data.network.api

import com.startup.toicoclub.data.network.model.newest.NewestResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface ApiHelper {

    @GET(ApiEndPoint.NEWEST)
    fun getNewest(
        @Query("method") name: String = "newest"
    ): Observable<NewestResponse>
}