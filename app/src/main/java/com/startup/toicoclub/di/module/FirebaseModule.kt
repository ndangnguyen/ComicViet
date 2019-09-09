package com.startup.toicoclub.di.module

import android.content.Context
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class FirebaseModule(var webClientId: String) {
    @Provides
    fun provideGoogleSignInOptions(): GoogleSignInOptions {
        return GoogleSignInOptions.Builder().apply {
            requestIdToken(webClientId)
            requestEmail()
        }.build()
    }

    @Provides
    fun provideGoogleSignInClient(@Named("ApplicationContext") context: Context, gso: GoogleSignInOptions): GoogleSignInClient {
        return GoogleSignIn.getClient(context, gso)
    }
}