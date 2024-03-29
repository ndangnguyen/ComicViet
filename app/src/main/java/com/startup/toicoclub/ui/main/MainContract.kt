package com.startup.toicoclub.ui.main

import com.startup.toicoclub.ui.base.IPresenter
import com.startup.toicoclub.ui.base.IView

interface MainContract {
    interface View : IView {
        fun goToLogin()
    }

    interface Presenter : IPresenter {
        fun signOut()
    }
}