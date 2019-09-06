package com.startup.toicoclub.ui.login

import com.startup.toicoclub.data.DataManager
import com.startup.toicoclub.data.network.model.User
import com.startup.toicoclub.ui.base.BasePresenter
import javax.inject.Inject

class LoginPresenter @Inject constructor(dataManager: DataManager) :
    BasePresenter<LoginContract.View>(dataManager), LoginContract.Presenter {

    override fun login(user: User) {
        mView.showProgress()

        mDataManager.getFirebaseHelper().getUserWithEmail(user.email, user.pass)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    mView.onLoginSuccess(user)
                } else {

                }
                mView.hideProgress()
            }
            .addOnFailureListener {
                mView.onLoginFailed(it.message ?: "Login Failed!")
            }
    }

    override fun register(user: User) {
        mView.showProgress()

        mDataManager.getFirebaseHelper().createUserWithEmail(user.email, user.pass)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    mView.onRegisterSuccess()
                }
                mView.hideProgress()
            }
            .addOnFailureListener {
                mView.onRegisterFailed(it.message ?: "Register Failed!")
            }
    }
}