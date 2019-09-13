package com.startup.toicoclub.data.network.model.category


import com.google.gson.annotations.SerializedName

data class Category(
    @SerializedName("count")
    var count: Int, // 38754
    @SerializedName("id")
    var id: Int, // 33
    @SerializedName("name")
    var name: String, // Women
    @SerializedName("url")
    var url: String, // https://wall.alphacoders.com/by_category.php?id=33&name=Women+Wallpapers

    var thumbURL: String
)