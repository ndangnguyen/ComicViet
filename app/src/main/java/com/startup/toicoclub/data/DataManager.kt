package com.startup.toicoclub.data

import com.startup.toicoclub.data.network.api.ApiHelper
import com.startup.toicoclub.data.network.firebase.FirebaseHelper

interface DataManager {
    fun getFirebaseHelper(): FirebaseHelper
    fun getApiHelper(): ApiHelper
}