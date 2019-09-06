package com.startup.toicoclub.data.network.model


import com.google.gson.annotations.SerializedName

data class Sys(
    @SerializedName("country")
    val country: String,
    @SerializedName("message")
    val message: Double,
    @SerializedName("sunrise")
    val sunrise: Int,
    @SerializedName("sunset")
    val sunset: Int
)