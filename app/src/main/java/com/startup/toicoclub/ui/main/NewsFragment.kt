package com.startup.toicoclub.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.startup.toicoclub.R
import com.startup.toicoclub.ui.base.BaseFragment
import kotlinx.android.synthetic.main.news_frag.*


class NewsFragment : BaseFragment() {

    companion object {
        const val KEY_ARG_1: String = "arg"
        fun newInstance(name: String): NewsFragment {
            val bundle = Bundle()
            bundle.putString(KEY_ARG_1, name)
            return NewsFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun onInit() {

    }

    override fun setLayout(): Int {
        return R.layout.news_frag
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val bundle: Bundle? = arguments
        val name = bundle?.getString(KEY_ARG_1, "")
//        Snackbar.make(view!!, name!!, Snackbar.LENGTH_LONG)
        tvName?.text = name
    }


}