package com.nguyennguyendang.comicviet.ui.base

open class BasePresenter<V> {
    var mView: V? = null

    fun attach(view: V) {
        this.mView = view
    }

    fun detach() {
        mView = null
    }

}