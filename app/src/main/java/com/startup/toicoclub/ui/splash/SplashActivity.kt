package com.startup.toicoclub.ui.splash

import android.app.ActivityOptions
import android.os.Bundle
import android.os.Handler
import com.startup.toicoclub.R
import com.startup.toicoclub.ui.base.BaseActivity
import com.startup.toicoclub.ui.login.LoginActivityIntent
import com.startup.toicoclub.ui.main.MainActivityIntent
import javax.inject.Inject

class SplashActivity : BaseActivity(), SplashContract.View {

    @Inject
    lateinit var mPresenter: SplashPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mComponent.inject(this)
        mPresenter.attach(this)
    }

    override fun onStart() {
        super.onStart()
        Handler().postDelayed({
            mPresenter.checkAuthenticate()
        }, 1500)

    }

    override fun setLayout(): Int {
        return R.layout.activity_splash
    }

    override fun goToMain() {
        startActivity(
            MainActivityIntent(),
            ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
        )
    }

    override fun goToLogin() {
        startActivity(
            LoginActivityIntent(),
            ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
        )
    }
}
