package com.nguyennguyendang.comicviet.ui.main

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.nguyennguyendang.comicviet.R
import com.nguyennguyendang.comicviet.data.network.model.User
import com.nguyennguyendang.comicviet.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*


fun Context.MainActivityIntent(): Intent {
    return Intent(this, MainActivity::class.java).apply {
    }
}

class MainActivity : BaseActivity() {

    override fun setLayout(): Int {
        return R.layout.activity_main
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        vpMain.adapter = MainViewPagerAdapter(supportFragmentManager)
        tlMain.setupWithViewPager(vpMain)
    }

}
