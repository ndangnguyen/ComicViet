@file:Suppress("DEPRECATION")

package com.startup.toicoclub.ui.base

import android.app.ProgressDialog
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.snackbar.Snackbar
import com.mindorks.framework.mvp.util.CommonUtil
import com.startup.toicoclub.APP
import com.startup.toicoclub.di.component.ActivityComponent
import com.startup.toicoclub.di.component.DaggerActivityComponent
import android.graphics.Typeface
import android.R
import android.R.id
import android.content.Context
import android.widget.TextView
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.inputmethod.InputMethodManager
import es.dmoral.toasty.Toasty


abstract class BaseActivity : AppCompatActivity(), IView {

    abstract fun setLayout(): Int

    private var progressDialog: ProgressDialog? = null

    private lateinit var snackbar: Snackbar

    var mComponent: ActivityComponent? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(setLayout())
        super.onCreate(savedInstanceState)
        mComponent = DaggerActivityComponent.builder()
            .applicationComponent((application as APP).appComponent)
            .build()
    }

    override fun onDestroy() {
        super.onDestroy()
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
        val textView = snackbarView.findViewById<TextView>(com.google.android.material.R.id.snackbar_text)
        textView.setTextColor(resources.getColor(R.color.white))
        snackbar.show()
    }

    override fun showToasty(text: String) {
        Toasty.success(this, text, Toast.LENGTH_SHORT, true).show();
    }

    override fun hideKeyboard() {
        val view = this.currentFocus
        view?.let { v ->
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
            imm?.let { it.hideSoftInputFromWindow(v.windowToken, 0) }
        }
    }
}