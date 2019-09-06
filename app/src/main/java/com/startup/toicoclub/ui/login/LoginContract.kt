package com.startup.toicoclub.ui.login

import com.startup.toicoclub.data.network.model.User
import com.startup.toicoclub.ui.base.IPresenter
import com.startup.toicoclub.ui.base.IView

interface LoginContract {
    interface Presenter: IPresenter {
        fun login(user: User)
        fun register(user: User)
    }

    interface View: IView {
        fun onLoginSuccess(user: User)
        fun onLoginFailed(msg: String)
        fun onRegisterSuccess()
        fun onRegisterFailed(msg: String)
        fun openMainActivity()
        fun isInputValidated(): Boolean
    }
}