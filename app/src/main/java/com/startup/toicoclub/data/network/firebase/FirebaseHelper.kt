package com.startup.toicoclub.data.network.firebase

import androidx.annotation.CallSuper
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.startup.toicoclub.data.network.model.User

interface FirebaseHelper {
    fun getUserWithEmail(email: String, password: String): Task<AuthResult>
    fun createUserWithEmail(email: String, password: String): Task<AuthResult>
    fun deleteUser(uid: String)
    fun updateUser(user: User)
}