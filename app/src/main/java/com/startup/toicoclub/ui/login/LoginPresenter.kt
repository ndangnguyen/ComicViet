package com.startup.toicoclub.ui.login

import android.util.Log
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthCredential
import com.google.firebase.auth.GoogleAuthProvider
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

    override fun facebookSignIn() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun handleGoogleSignInResult(task: Task<GoogleSignInAccount>) {
        try {
            var googleSignInAccount: GoogleSignInAccount? = task.getResult(ApiException::class.java)
            firebaseAuthWithGoogle(googleSignInAccount!!)
        }
        catch (e: ApiException) {
            // Google Sign In failed, update UI appropriately
            mView.onLoginFailed("Login Failed!")



            Log.d("Nguyen", "Google sign in failed" + e.toString())


        }
    }

    override fun firebaseAuthWithGoogle(googleSignInAccount: GoogleSignInAccount) {
        val credential: AuthCredential =
            GoogleAuthProvider.getCredential(googleSignInAccount.idToken, null)
        mDataManager.getFirebaseHelper().signInWithCredential(credential)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    mView.onLoginSuccess(User(it.result!!.user!!.email.toString(), ""))
                } else {

                }
                mView.hideProgress()
            }
            .addOnFailureListener {
                mView.onLoginFailed(it.message ?: "Login Failed!")
            }
    }
}