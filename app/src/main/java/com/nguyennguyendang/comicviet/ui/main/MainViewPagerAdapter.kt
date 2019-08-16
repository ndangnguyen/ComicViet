package com.nguyennguyendang.comicviet.ui.main

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import androidx.viewpager.widget.ViewPager

class MainViewPagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager) {
    override fun getItem(position: Int): Fragment? {
        var fragment: Fragment? = null
        when (position) {
            0 -> {
                fragment = NewsFragment.newInstance("NGUYEN DEP TRAI")
            }
            1 -> {
                fragment = NewsFragment.newInstance("NGUYEN XINH GAI")
            }
            2 -> {
                fragment = NewsFragment.newInstance("NGUYEN CHUAN MEN")
            }
        }
        return fragment
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> "Nguyen dep trai"
        1 -> "Nguyen xinh gai"
        2 -> "Nguyen chuan men"
        else -> null
    }
}