package com.startup.toicoclub.ui.login

import android.app.ActivityOptions
import android.os.Bundle
import android.text.TextUtils
import android.transition.TransitionManager
import android.util.Patterns
import android.view.View
import com.startup.toicoclub.R
import com.startup.toicoclub.data.network.model.User
import com.startup.toicoclub.ui.base.BaseActivity
import com.startup.toicoclub.ui.main.MainActivityIntent
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


class LoginActivity : BaseActivity(), LoginContract.View {

    companion object {
        const val TAG: String = "LoginActivity"
    }

    var isLogin: Boolean = true

    @Inject
    lateinit var mPresenter: LoginPresenter

    override fun setLayout(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mComponent?.inject(this)
        mPresenter.attach(this)
        supportActionBar?.hide()
        setListener()
    }

    private fun setListener() {
        btnLogin.setOnClickListener {
            hideKeyboard()
            if (isInputValidated())
                mPresenter.login(
                    User(
                        etEmail.text.toString().trim(),
                        etPass.text.toString().trim()
                    )
                )
        }

        btnSignIn.setOnClickListener {
            hideKeyboard()
            if (isInputValidated())
                mPresenter.register(
                    User(
                        etEmail.text.toString().trim(),
                        etPass.text.toString().trim()
                    )
                )
        }

        tvNeedAcount.setOnClickListener {
            TransitionManager.beginDelayedTransition(clLogin)
            when (isLogin) {
                true -> {
                    isLogin = false
                    tvPass2.visibility = View.VISIBLE
                    btnLogin.visibility = View.GONE
                    btnSignIn.visibility = View.VISIBLE
                    tvNeedAcount.text = getString(R.string.already_have_account)
                }
                false -> {
                    isLogin = true
                    tvPass2.visibility = View.GONE
                    btnLogin.visibility = View.VISIBLE
                    btnSignIn.visibility = View.GONE
                    tvNeedAcount.text = getString(R.string.need_a_account)
                }
            }
        }
    }

    override fun isInputValidated(): Boolean {
        if (!isValidEmail(etEmail.text)) {
            showToast(getString(R.string.email_invalid))
            return false
        }
        if (TextUtils.isEmpty(etPass.text)) {
            showToast(getString(R.string.miss_password))
            return false
        }
        if (!isLogin) {
            if (TextUtils.isEmpty(etPass2.text)) {
                showToast(getString(R.string.miss_re_enter_password))
                return false
            }
            if (etPass.text.toString() != etPass2.text.toString()) {
                showToast(getString(R.string.password_missmatch))
                return false
            }
        }
        return true
    }

    fun isValidEmail(target: CharSequence?): Boolean {
        return !TextUtils.isEmpty(target) && Patterns.EMAIL_ADDRESS.matcher(target).matches()
    }

    override fun onLoginSuccess(user: User) {
        showToasty(getString(R.string.login_success))
        openMainActivity()
    }

    override fun onLoginFailed(msg: String) {
        showSnackbar(clLogin, msg)
    }

    override fun onDestroy() {
        super.onDestroy()
        mPresenter.detach()
    }

    override fun openMainActivity() {
        startActivity(MainActivityIntent(), ActivityOptions.makeSceneTransitionAnimation(this).toBundle())

    }

    override fun onRegisterSuccess() {
        tvNeedAcount.performClick()
        showToasty(getString(R.string.register_success))
    }

    override fun onRegisterFailed(msg: String) {
        showSnackbar(clLogin, msg)
    }
}