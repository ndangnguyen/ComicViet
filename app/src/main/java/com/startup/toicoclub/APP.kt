package com.startup.toicoclub

import android.app.Application
import com.startup.toicoclub.di.component.ApplicationComponent
import com.startup.toicoclub.di.component.DaggerApplicationComponent
import com.startup.toicoclub.di.module.ApplicationModule

class APP : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.builder()
            .applicationModule(ApplicationModule(applicationContext))
            .build()
        appComponent.inject(this)

    }
}