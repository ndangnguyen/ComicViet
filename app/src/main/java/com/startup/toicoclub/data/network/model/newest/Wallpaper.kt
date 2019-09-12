package com.startup.toicoclub.data.network.model.newest


import com.google.gson.annotations.SerializedName

data class Wallpaper(
    @SerializedName("category")
    var category: String, // Earth
    @SerializedName("category_id")
    var categoryId: String, // 10
    @SerializedName("file_size")
    var fileSize: String, // 7540096
    @SerializedName("file_type")
    var fileType: String, // jpg
    @SerializedName("height")
    var height: String, // 3840
    @SerializedName("id")
    var id: String, // 1040410
    @SerializedName("sub_category")
    var subCategory: String, // Flower
    @SerializedName("sub_category_id")
    var subCategoryId: String, // 168633
    @SerializedName("url_image")
    var urlImage: String, // https://images2.alphacoders.com/104/1040410.jpg
    @SerializedName("url_page")
    var urlPage: String, // https://wall.alphacoders.com/big.php?i=1040410
    @SerializedName("url_thumb")
    var urlThumb: String, // https://images2.alphacoders.com/104/thumb-1040410.jpg
    @SerializedName("user_id")
    var userId: String, // 174661
    @SerializedName("user_name")
    var userName: String, // Tommyboy42
    @SerializedName("width")
    var width: String // 5760
)