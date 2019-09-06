package com.startup.toicoclub

import android.app.Application
import com.startup.toicoclub.di.component.ApplicationComponent
import com.startup.toicoclub.di.component.DaggerApplicationComponent

class APP : Application() {

    lateinit var appComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerApplicationComponent.create()
        appComponent.inject(this)
    }
}