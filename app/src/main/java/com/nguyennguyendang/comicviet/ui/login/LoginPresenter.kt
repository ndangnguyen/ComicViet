package com.nguyennguyendang.comicviet.ui.login

import com.nguyennguyendang.comicviet.data.network.model.User

class LoginPresenter(var view: LoginContract.View): LoginContract.Presenter{

    init {
        view.setPresenter(this)
    }

    override fun validateData(user: User) {
        if (user.id.equals("Nguyen") && user.pass.equals("123"))
            view.onLoginSuccess(user)
        else view.onLoginFailed()
    }

    override fun start() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}