package com.startup.toicoclub.di.module

import android.app.Application
import com.startup.toicoclub.APP
import com.startup.toicoclub.data.AppDataManager
import com.startup.toicoclub.data.DataManager
import com.startup.toicoclub.data.network.firebase.AppFirebaseHelper
import com.startup.toicoclub.data.network.firebase.FirebaseHelper
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule {
    @Provides
    @Singleton
    fun provideApplication(): Application
            = APP()

    @Provides
    @Singleton
    fun provideDataManager(appDataManager: AppDataManager): DataManager
            = appDataManager

    @Provides
    @Singleton
    fun provideFirebaseHelper(appFirebaseHelper: AppFirebaseHelper): FirebaseHelper
            = appFirebaseHelper
}