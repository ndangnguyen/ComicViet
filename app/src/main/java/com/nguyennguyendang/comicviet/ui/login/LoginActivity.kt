package com.nguyennguyendang.comicviet.ui.login

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.nguyennguyendang.comicviet.R
import com.nguyennguyendang.comicviet.data.network.model.User
import com.nguyennguyendang.comicviet.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: BaseActivity(), LoginContract.View {
    private lateinit var mPresenter: LoginContract.Presenter

    override fun setPresenter(presenter: LoginContract.Presenter) {
        mPresenter = checkNotNull(presenter)
    }
    override fun setLayout(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        LoginPresenter(this)
        setListener()
    }

    private fun setListener() {
        btnLogin.setOnClickListener{
            mPresenter.validateData(User(etName.text.toString(), etPass.text.toString()))
        }
    }

    override fun onLoginSuccess(user: User) {
        Snackbar.make(container, "${user.id} Dep Trai!!!", Snackbar.LENGTH_LONG).show()
    }

    override fun onLoginFailed() {
        Snackbar.make(container, "Check again!!!", Snackbar.LENGTH_LONG).show()
    }
}