package com.startup.toicoclub.ui.base

interface IPresenter {
    fun attach(view: IView)
    fun detach()
}