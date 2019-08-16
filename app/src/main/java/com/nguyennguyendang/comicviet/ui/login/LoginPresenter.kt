package com.nguyennguyendang.comicviet.ui.login

import com.nguyennguyendang.comicviet.data.network.model.User
import com.nguyennguyendang.comicviet.ui.base.BasePresenter

class LoginPresenter : BasePresenter<LoginContract.View>(), LoginContract.Presenter {

    override fun validateData(user: User) {
        if (user.id.equals("Nguyen") && user.pass.equals("123"))
            mView?.onLoginSuccess(user)
        else mView?.onLoginFailed()
    }


}