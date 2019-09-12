package com.startup.toicoclub.ui.hot

import com.startup.toicoclub.ui.base.IPresenter
import com.startup.toicoclub.ui.base.IView

interface HotContract {

    interface View: IView {
        fun onReceiveData()
    }

    interface Presenter: IPresenter {
        fun loadHotImage()
    }
}