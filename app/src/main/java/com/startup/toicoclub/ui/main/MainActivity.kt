package com.startup.toicoclub.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.startup.toicoclub.R
import kotlinx.android.synthetic.main.activity_main.*


fun Context.MainActivityIntent(): Intent {
    return Intent(this, MainActivity::class.java).apply {
    }
}

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vpMain.adapter = MainViewPagerAdapter(supportFragmentManager)
        tlMain.setupWithViewPager(vpMain)
    }

}
