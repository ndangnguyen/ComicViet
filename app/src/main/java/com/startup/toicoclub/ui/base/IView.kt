package com.startup.toicoclub.ui.base

import android.view.View

interface IView {
    fun showProgress()
    fun hideProgress()
    fun showToast(text: String)
    fun showSnackbar(view: View, text: String)
    fun showToasty(text: String)
    fun hideKeyboard()
}