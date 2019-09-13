package com.startup.toicoclub.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.startup.toicoclub.ui.newest.CategoryFragment
import com.startup.toicoclub.ui.newest.NewestFragment

class MainViewPagerAdapter(fragmentManager: FragmentManager) :
    FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    var fragmentList: ArrayList<Fragment> = ArrayList()

    init {
        fragmentList.add(NewestFragment())
        fragmentList.add(CategoryFragment())
        fragmentList.add(NewsFragment.newInstance("C"))
    }

    override fun getItem(position: Int): Fragment {
        return fragmentList[position]
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence? = when (position) {
        0 -> "Newest"
        1 -> "Category"
        2 -> "Nguyen chuan men"
        else -> null
    }
}