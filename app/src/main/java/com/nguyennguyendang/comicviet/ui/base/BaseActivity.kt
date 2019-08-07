package com.nguyennguyendang.comicviet.ui.base

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.nguyennguyendang.comicviet.ui.login.LoginContract
import kotlinx.android.synthetic.main.activity_login.*

abstract class BaseActivity : AppCompatActivity(), LoginContract.View {
    abstract fun setLayout() : Int

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(setLayout())
    }
}