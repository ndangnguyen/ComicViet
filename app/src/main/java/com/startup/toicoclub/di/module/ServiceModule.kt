package com.startup.toicoclub.di.module

//import okhttp3.logging.HttpLoggingInterceptor
import com.startup.toicoclub.data.network.api.ApiEndPoint
import com.startup.toicoclub.data.network.api.ApiHelper
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

@Module
class ServiceModule {

    private val CONNECT_TIMEOUT_TIME = 20

    @Provides
    fun provideRetrofit(
        gson: GsonConverterFactory,
        rxJava: RxJava2CallAdapterFactory,
        okHttp: OkHttpClient
    ): Retrofit =
        Retrofit.Builder().apply {
            baseUrl(ApiEndPoint.ENDPOINT_URL)
            client(okHttp)
            addCallAdapterFactory(rxJava)
            addConverterFactory(gson)
        }.build()

    @Provides
    fun provideGson(): GsonConverterFactory = GsonConverterFactory.create()

    @Provides
    fun provideRxJava(): RxJava2CallAdapterFactory = RxJava2CallAdapterFactory.create()

    @Provides
    fun provideOkHttp(): OkHttpClient {
        return OkHttpClient.Builder().apply {
            readTimeout(CONNECT_TIMEOUT_TIME.toLong(), TimeUnit.SECONDS)
            connectTimeout(CONNECT_TIMEOUT_TIME.toLong(), TimeUnit.SECONDS)
            retryOnConnectionFailure(false)
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }.build()
    }

    @Provides
    fun provideAppServices(retrofit: Retrofit): ApiHelper = retrofit.create(
        ApiHelper::class.java
    )
}