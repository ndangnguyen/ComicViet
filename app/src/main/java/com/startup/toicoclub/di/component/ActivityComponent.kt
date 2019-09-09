package com.startup.toicoclub.di.component

import com.startup.toicoclub.di.anotation.PerActivity
import com.startup.toicoclub.di.module.ActivityModule
import com.startup.toicoclub.di.module.FirebaseModule
import com.startup.toicoclub.ui.login.LoginActivity
import com.startup.toicoclub.ui.main.MainActivity
import com.startup.toicoclub.ui.splash.SplashActivity
import dagger.Component

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class, FirebaseModule::class])
interface ActivityComponent {
    fun inject(loginActivity: LoginActivity)
    fun inject(mainActivity: MainActivity)
    fun inject(splashActivity: SplashActivity)
}