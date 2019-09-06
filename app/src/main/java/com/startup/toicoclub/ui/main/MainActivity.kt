package com.startup.toicoclub.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.startup.toicoclub.R
import com.startup.toicoclub.ui.base.BaseActivity
import com.startup.toicoclub.ui.login.LoginActivityIntent
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


fun Context.MainActivityIntent(): Intent {
    return Intent(this, MainActivity::class.java).apply {
    }
}

class MainActivity : BaseActivity(), MainContract.View {

    @Inject
    lateinit var mainPresenter: MainPresenter

    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        vpMain.adapter = MainViewPagerAdapter(supportFragmentManager)
        tlMain.setupWithViewPager(vpMain)
        mComponent.inject(this)
        mainPresenter.attach(this)
        setListener()
    }

    private fun setListener() {
        nvMain.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.itLogout -> {
                    mainPresenter.signOut()
                    true
                }
                else -> false
            }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.itLogout -> mainPresenter.signOut()
        }
        return super.onOptionsItemSelected(item)
    }

    override fun goToLogin() {
        startActivity(LoginActivityIntent())
    }
}
