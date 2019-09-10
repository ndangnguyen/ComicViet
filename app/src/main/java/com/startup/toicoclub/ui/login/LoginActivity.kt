package com.startup.toicoclub.ui.login

import android.annotation.TargetApi
import android.app.ActivityOptions
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.text.Html
import android.text.TextUtils
import android.transition.TransitionManager
import android.util.Patterns
import android.view.View
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInClient
import com.google.android.gms.tasks.Task
import com.startup.toicoclub.R
import com.startup.toicoclub.data.network.model.User
import com.startup.toicoclub.ui.base.BaseActivity
import com.startup.toicoclub.ui.main.MainActivityIntent
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject


fun Context.LoginActivityIntent(): Intent {
    return Intent(this, LoginActivity::class.java).apply {
    }
}

class LoginActivity : BaseActivity(), LoginContract.View {

    companion object {
        const val TAG: String = "LoginActivity"
    }

    var isLogin: Boolean = true

    val RC_SIGN_IN = 1

    @Inject
    lateinit var mPresenter: LoginPresenter

    @Inject
    lateinit var googleSignInClient: GoogleSignInClient

    override fun setLayout(): Int {
        return R.layout.activity_login
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mComponent.inject(this)
        mPresenter.attach(this)
        supportActionBar?.hide()
        setListener()
    }

    @TargetApi(Build.VERSION_CODES.N)
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
                    tvNeedAcount.text = Html.fromHtml(
                        getString(R.string.already_have_account),
                        Html.FROM_HTML_MODE_COMPACT
                    )
                }
                false -> {
                    isLogin = true
                    tvPass2.visibility = View.GONE
                    btnLogin.visibility = View.VISIBLE
                    btnSignIn.visibility = View.GONE
                    tvNeedAcount.text = Html.fromHtml(
                        getString(R.string.need_a_account),
                        Html.FROM_HTML_MODE_COMPACT
                    )
                }
            }
        }

        ibGG.setOnClickListener {
            var intent: Intent = googleSignInClient.signInIntent
            startActivityForResult(intent, RC_SIGN_IN)
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
        startActivity(
            MainActivityIntent(),
            ActivityOptions.makeSceneTransitionAnimation(this).toBundle()
        )

    }

    override fun onRegisterSuccess() {
        tvNeedAcount.performClick()
        showToasty(getString(R.string.register_success))
    }

    override fun onRegisterFailed(msg: String) {
        showSnackbar(clLogin, msg)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode) {
            RC_SIGN_IN -> {

                var task: Task<GoogleSignInAccount> =
                    GoogleSignIn.getSignedInAccountFromIntent(data)
                mPresenter.handleGoogleSignInResult(task)
            }
        }
    }


}