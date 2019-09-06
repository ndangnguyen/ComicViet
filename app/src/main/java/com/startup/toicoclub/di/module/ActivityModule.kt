package com.startup.toicoclub.di.module

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class ActivityModule constructor(activity: AppCompatActivity) {

    private lateinit var mActivity: AppCompatActivity

    init {
        mActivity = activity
    }

    @Provides
    @Named("ActivityContext")
    fun provideContext(): Context = mActivity
}