package com.nguyennguyendang.comicviet.ui.login

import com.nguyennguyendang.comicviet.data.network.model.User
import com.nguyennguyendang.comicviet.ui.base.BasePresenter

interface LoginContract {
    interface Presenter {
        fun validateData(user: User)
    }

    interface View {
        fun onLoginSuccess(user: User)
        fun onLoginFailed()
        fun openMainActivity();
    }
}