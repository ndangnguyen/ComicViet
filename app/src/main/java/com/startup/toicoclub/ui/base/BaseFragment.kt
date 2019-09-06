@file:Suppress("DEPRECATION")

package com.startup.toicoclub.ui.base

import android.app.ProgressDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.core.content.ContextCompat.getSystemService
import androidx.fragment.app.Fragment
import com.google.android.material.snackbar.Snackbar
import com.mindorks.framework.mvp.util.CommonUtil
import es.dmoral.toasty.Toasty
import androidx.core.content.ContextCompat.getSystemService



abstract class BaseFragment<P : IPresenter> : Fragment(), IView {

    abstract fun setLayout(): Int

    private var progressDialog: ProgressDialog? = null

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(setLayout(), container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun hideProgress() {
        progressDialog?.let { if (it.isShowing) it.cancel() }
    }

    override fun showProgress() {
        hideProgress()
        progressDialog = CommonUtil.showLoadingDialog(context)
    }

    override fun showToast(text: String) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show()
    }

    override fun showSnackbar(view: View, text: String) {
        Snackbar.make(view, text, Snackbar.LENGTH_SHORT)
    }

    override fun showToasty(text: String) {
        Toasty.success(context!!, text, Toast.LENGTH_SHORT, true).show();
    }

    override fun hideKeyboard() {
        val imm = context?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager?
        imm!!.hideSoftInputFromWindow(view?.applicationWindowToken, 0)
    }
}