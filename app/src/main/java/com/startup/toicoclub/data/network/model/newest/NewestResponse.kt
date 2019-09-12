package com.startup.toicoclub.data.network.model.newest


import com.google.gson.annotations.SerializedName

data class NewestResponse(
    @SerializedName("success")
    var success: Boolean, // true
    @SerializedName("wallpapers")
    var wallpapers: List<Wallpaper>
)