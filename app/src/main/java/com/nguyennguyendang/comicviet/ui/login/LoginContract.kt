package com.nguyennguyendang.comicviet.ui.login

import com.nguyennguyendang.comicviet.data.network.model.User
import com.nguyennguyendang.comicviet.ui.base.BasePresenter
import com.nguyennguyendang.comicviet.ui.base.BaseView

interface LoginContract {
    interface Presenter: BasePresenter {
        fun validateData(user: User)
    }
    interface View: BaseView<Presenter> {
        fun onLoginSuccess(user: User)
        fun onLoginFailed()
    }
}