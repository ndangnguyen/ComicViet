package com.startup.toicoclub.ui.main

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.ActionBarDrawerToggle
import com.startup.toicoclub.R
import com.startup.toicoclub.ui.base.BaseActivity
import com.startup.toicoclub.ui.login.LoginActivityIntent
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.main.*
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
    }

    override fun onInit() {
        mComponent.inject(this)
        mainPresenter.attach(this)
        vpMain.adapter = MainViewPagerAdapter(supportFragmentManager)
        tlMain.setupWithViewPager(vpMain)
        setListener()
        initToolbar()
    }

    fun initToolbar() {
        setSupportActionBar(tbMain)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        title = getString(R.string.app_name)
        var actionBarDrawerToggle = ActionBarDrawerToggle(
            this, dlMain, tbMain,
            R.string.open_tool_bar, R.string.close_tool_bar
        )
        dlMain.addDrawerListener(actionBarDrawerToggle)
        actionBarDrawerToggle.setDrawerIndicatorEnabled(true)
        actionBarDrawerToggle.syncState()
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

    override fun goToLogin() {
        startActivity(LoginActivityIntent())
    }
}
