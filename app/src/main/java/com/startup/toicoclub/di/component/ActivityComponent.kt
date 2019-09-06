package com.startup.toicoclub.di.component

import com.startup.toicoclub.di.anotation.PerActivity
import com.startup.toicoclub.di.module.ActivityModule
import com.startup.toicoclub.ui.login.LoginActivity
import com.startup.toicoclub.ui.main.MainActivity
import dagger.Component
import javax.inject.Inject
import javax.inject.Singleton

@PerActivity
@Component(dependencies = [ApplicationComponent::class], modules = [ActivityModule::class])
interface ActivityComponent {
    fun inject(loginActivity: LoginActivity)
    fun inject(mainActivity: MainActivity)
}