package com.startup.toicoclub.ui.category

import android.annotation.SuppressLint
import com.startup.toicoclub.data.DataManager
import com.startup.toicoclub.data.network.model.category.Category
import com.startup.toicoclub.ui.base.BasePresenter
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class CategoryPresenter @Inject constructor(dataManager: DataManager):
    BasePresenter<CategoryContract.View>(dataManager), CategoryContract.Presenter {

    var categories: ArrayList<Category> = ArrayList()

    @SuppressLint("CheckResult")
    override fun loadCategoryList() {
        mDataManager.getApiHelper().getCategoryList()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe{
                mView.onReceiverData(it.categories as ArrayList<Category>)
                this.categories.clear()
                this.categories.addAll(it.categories)
            }

        for (category in categories) {
            mDataManager.getApiHelper().getImageByCategoryId(category.id)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe {
                    category.thumbURL = it.wallpapers[0].urlImage
                    //ca
                }
        }

        mView.onReceiverData(categories)
    }
}