package com.startup.toicoclub.ui.splash

import com.google.firebase.auth.FirebaseUser
import com.startup.toicoclub.data.DataManager
import com.startup.toicoclub.ui.base.BasePresenter
import javax.inject.Inject

class SplashPresenter @Inject constructor(dataManager: DataManager) :
    BasePresenter<SplashContract.View>(dataManager), SplashContract.Presenter {
    override fun isAuthenticated(): Boolean {
        val firebaseUser: FirebaseUser? = mDataManager.getFirebaseHelper().getCurrentUser()
        return firebaseUser != null
    }

    override fun checkAuthenticate() {
        if (isAuthenticated()) mView.goToMain() else mView.goToLogin()
    }
}