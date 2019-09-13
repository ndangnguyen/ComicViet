package com.startup.toicoclub.data.network.api

object ApiEndPoint {
    private const val API_KEY = "b175682a66481e7b7a811bcb26272ac4"
    const val ENDPOINT_URL2 = "https://wall.alphacoders.com/api2.0/get.php?auth=$API_KEY"
    const val ENDPOINT_URL = "https://wall.alphacoders.com/api2.0/"
    const val WEATHER = "/weather"
    const val NEWEST = "get.php?auth=$API_KEY&method=newest"
    const val CATEGORY_LIST = "get.php?auth=$API_KEY&method=category_list"
    const val IMAGE_BY_CATEGORY = "get.php?auth=$API_KEY&method=category"
}