@file:Suppress("DEPRECATION")

package com.startup.toicoclub.ui.base


import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.mindorks.framework.mvp.util.CommonUtil
import com.startup.toicoclub.APP
import com.startup.toicoclub.R
import com.startup.toicoclub.di.component.ActivityComponent
import com.startup.toicoclub.di.component.DaggerActivityComponent
import com.startup.toicoclub.di.module.FirebaseModule
import es.dmoral.toasty.Toasty


abstract class BaseActivity : AppCompatActivity(), IView {

    abstract fun setLayout(): Int

    abstract fun onInit()

    private var progressDialog: ProgressDialog? = null

    private lateinit var snackbar: Snackbar

    lateinit var mComponent: ActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(setLayout())
        super.onCreate(savedInstanceState)
        mComponent = DaggerActivityComponent.builder()
            .firebaseModule(FirebaseModule(getString(R.string.default_client_id)))
            .applicationComponent((application as APP).appComponent)
            .build()
        onInit()
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(this)
    }

    override fun showToast(text: String) {
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    override fun showSnackbar(view: View, text: String) {
        snackbar = Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
        val snackbarView = snackbar.view
        val textView =
            snackbarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        textView.setTextColor(resources.getColor(R.color.white))
        snackbar.show()
    }

    override fun showToasty(text: String) {
        Toasty.success(this, text, Toast.LENGTH_SHORT, true).show()
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        view?.let { v ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.hideSoftInputFromWindow(v.windowToken, 0)
        }
    }
}