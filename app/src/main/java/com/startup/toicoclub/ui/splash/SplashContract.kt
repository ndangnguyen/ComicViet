package com.startup.toicoclub.ui.splash

import com.startup.toicoclub.ui.base.IPresenter
import com.startup.toicoclub.ui.base.IView

interface SplashContract {
    interface View : IView {
        fun goToMain()
        fun goToLogin()
    }

    interface Presenter : IPresenter {
        fun isAuthenticated(): Boolean
        fun checkAuthenticate()
    }
}