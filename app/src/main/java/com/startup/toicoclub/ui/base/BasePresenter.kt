package com.startup.toicoclub.ui.base

import com.startup.toicoclub.data.DataManager
import com.startup.toicoclub.di.component.ApplicationComponent
import com.startup.toicoclub.di.component.DaggerApplicationComponent
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable
import javax.inject.Inject

open class BasePresenter<V : IView> @Inject constructor(dataManager: DataManager) : IPresenter {

    lateinit var mView: V
    var mDataManager: DataManager

    private var compositeDisposable = CompositeDisposable()

    init {
        mDataManager = dataManager
    }

    @Suppress("UNCHECKED_CAST")
    override fun attach(view: IView) {
        this.mView = view as V
    }

    override fun detach() {
        if (!compositeDisposable.isDisposed) {
            compositeDisposable.clear()
        }
    }

    fun getView(): V {
        return mView
    }

    fun addSubscription(disposable: Disposable) {
        compositeDisposable.add(disposable)
    }
}