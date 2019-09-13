package com.startup.toicoclub.ui.category

import com.startup.toicoclub.data.network.model.category.Category
import com.startup.toicoclub.ui.base.IPresenter
import com.startup.toicoclub.ui.base.IView

interface CategoryContract {
    interface View : IView {
        fun onReceiverData(category: ArrayList<Category>)
    }

    interface Presenter : IPresenter {
        fun loadCategoryList()
    }
}