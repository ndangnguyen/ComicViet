package com.startup.toicoclub.ui.newest

import com.startup.toicoclub.data.DataManager
import com.startup.toicoclub.data.network.model.newest.Wallpaper
import com.startup.toicoclub.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class NewestPresenter @Inject constructor(dataManager: DataManager) :
    BasePresenter<NewestContract.View>(dataManager), NewestContract.Presenter {

    override fun loadNewestData() {
        mDataManager.getApiHelper().getNewest().observeOn(AndroidSchedulers.mainThread())
            .subscribeOn(Schedulers.io())
            .subscribe {
                var list = it.wallpapers
                mView.onReceiverData(list as ArrayList<Wallpaper>)
            }
    }
}