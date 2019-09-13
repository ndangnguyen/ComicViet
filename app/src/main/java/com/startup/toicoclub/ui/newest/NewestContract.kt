package com.startup.toicoclub.ui.newest

import com.startup.toicoclub.data.network.model.newest.Wallpaper
import com.startup.toicoclub.ui.base.IPresenter
import com.startup.toicoclub.ui.base.IView

interface NewestContract {
    interface View: IView {
        fun onReceiverData(wallpapers: ArrayList<Wallpaper>)
    }
    interface Presenter: IPresenter {
        fun loadNewestData()
    }
}