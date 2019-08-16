package com.nguyennguyendang.comicviet.ui.login

import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import com.nguyennguyendang.comicviet.R
import com.nguyennguyendang.comicviet.data.network.model.User
import com.nguyennguyendang.comicviet.ui.base.BaseActivity
import com.nguyennguyendang.comicviet.ui.main.MainActivity
import com.nguyennguyendang.comicviet.ui.main.MainActivityIntent
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity: BaseActivity(), LoginContract.View {
    companion object {
        const val TAG: String = "LoginActivity"
    }
    private var mPresenter: LoginPresenter = LoginPresenter()

    override fun setLayout(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        mPresenter.attach(this)
        setListener()
    }

    private fun setListener() {
        btnLogin.setOnClickListener{
            mPresenter.validateData(User(etName.text.toString(), etPass.text.toString()))
        }
    }

    override fun onLoginSuccess(user: User) {
        Snackbar.make(container, "${user.id} Dep Trai!!!", Snackbar.LENGTH_LONG).show()
        openMainActivity()
    }

    override fun onLoginFailed() {
        Snackbar.make(container, "Check again!!!", Snackbar.LENGTH_LONG).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detach()
    }

    override fun openMainActivity() {
        startActivity(MainActivityIntent())

    }
}