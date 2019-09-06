package com.startup.toicoclub.ui.main

import com.startup.toicoclub.data.DataManager
import com.startup.toicoclub.ui.base.BasePresenter
import javax.inject.Inject

class MainPresenter @Inject constructor(dataManager: DataManager): BasePresenter<MainContract.View>(dataManager), MainContract.Presenter {

}