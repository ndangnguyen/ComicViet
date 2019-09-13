package com.startup.toicoclub.data.network.api

import com.startup.toicoclub.data.network.model.category.CategoryResponse
import com.startup.toicoclub.data.network.model.newest.WallpaperResponse
import com.startup.toicoclub.data.network.model.newest.Wallpaper
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiHelper {

    @GET(ApiEndPoint.NEWEST)
    fun getNewest(): Observable<WallpaperResponse>

    @GET(ApiEndPoint.CATEGORY_LIST)
    fun getCategoryList(): Observable<CategoryResponse>

    @GET(ApiEndPoint.IMAGE_BY_CATEGORY)
    fun getImageByCategoryId(
        @Query("id") id: Int
    ): Observable<WallpaperResponse>
}