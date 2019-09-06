package com.startup.toicoclub.data.network.firebase

import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.startup.toicoclub.data.network.model.User
import javax.inject.Inject


class AppFirebaseHelper @Inject constructor() : FirebaseHelper {


    private val firebaseAuth: FirebaseAuth by lazy { FirebaseAuth.getInstance() }

    override fun getUserWithEmail(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.signInWithEmailAndPassword(email, password)
    }

    override fun createUserWithEmail(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.createUserWithEmailAndPassword(email, password)
    }

    override fun deleteUser(uid: String) {

    }

    override fun updateUser(user: User) {

    }

    override fun getCurrentUser(): FirebaseUser? {
        return firebaseAuth.currentUser
    }

    override fun signOut() {
        firebaseAuth.signOut()
    }
}