package com.startup.toicoclub.di.component

import android.content.Context
import com.startup.toicoclub.APP
import com.startup.toicoclub.data.DataManager
import com.startup.toicoclub.data.network.api.ApiHelper
import com.startup.toicoclub.di.module.ApplicationModule
import com.startup.toicoclub.di.module.ServiceModule
import dagger.Component
import javax.inject.Named
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class, ServiceModule::class])
interface ApplicationComponent {
    fun inject(app: APP)

    fun getServices(): ApiHelper

    fun getDataManager(): DataManager

    @Named("ApplicationContext")
    fun getApplicationContext(): Context
}