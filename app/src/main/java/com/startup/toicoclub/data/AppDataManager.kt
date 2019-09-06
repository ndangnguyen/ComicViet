package com.startup.toicoclub.data

import com.startup.toicoclub.data.network.api.ApiHelper
import com.startup.toicoclub.data.network.firebase.FirebaseHelper
import javax.inject.Inject

class AppDataManager @Inject constructor(firebaseHelper: FirebaseHelper, apiHelper: ApiHelper) : DataManager {
    var mFirebaseHelper: FirebaseHelper
    var mApiHelper: ApiHelper

    init {
        mFirebaseHelper = firebaseHelper
        mApiHelper = apiHelper
    }


    override fun getFirebaseHelper(): FirebaseHelper {
        return mFirebaseHelper
    }

    override fun getApiHelper(): ApiHelper {
        return mApiHelper
    }

}