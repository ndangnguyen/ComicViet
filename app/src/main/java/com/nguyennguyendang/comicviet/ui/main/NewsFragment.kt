package com.nguyennguyendang.comicviet.ui.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.snackbar.Snackbar
import com.nguyennguyendang.comicviet.R
import com.nguyennguyendang.comicviet.ui.base.BaseFragment
import kotlinx.android.synthetic.main.news_frag.*


class NewsFragment : BaseFragment() {

    companion object {
        const val KEY_ARG_1: String = "arg"
        fun newInstance(name: String): NewsFragment {
            var bundle = Bundle()
            bundle.putString(KEY_ARG_1, name)
            return NewsFragment().apply {
                arguments = bundle
            }
        }
    }

    override fun setLayout(): Int {
        return R.layout.news_frag
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var bundle: Bundle? = arguments
        var name = bundle?.getString(KEY_ARG_1, "")
//        Snackbar.make(view!!, name!!, Snackbar.LENGTH_LONG)
        tvName?.text = name
    }

}