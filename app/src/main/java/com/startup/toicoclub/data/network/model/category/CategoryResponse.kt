package com.startup.toicoclub.data.network.model.category


import com.google.gson.annotations.SerializedName

data class CategoryResponse(
    @SerializedName("categories")
    var categories: List<Category>,
    @SerializedName("success")
    var success: Boolean // true
)