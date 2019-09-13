package com.startup.toicoclub.ui.newest

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.startup.toicoclub.R
import com.startup.toicoclub.data.network.model.newest.Wallpaper
import com.startup.toicoclub.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_newest.*
import javax.inject.Inject

class NewestFragment : BaseFragment(), NewestContract.View {

    @Inject
    lateinit var mPresenter: NewestPresenter
    lateinit var adapter: NewestAdapter
    var wallpapers: ArrayList<Wallpaper> = ArrayList()

    override fun setLayout(): Int {
        return R.layout.fragment_newest
    }

    override fun onInit() {
        getComponent().inject(this)
        mPresenter.attach(this)
        adapter = NewestAdapter(wallpapers)
        rvNewest.adapter = this.adapter
        rvNewest.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)

        mPresenter.loadNewestData()
    }

    override fun onReceiverData(wallpapers: ArrayList<Wallpaper>) {
        this.wallpapers.clear()
        this.wallpapers.addAll(wallpapers)
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.detach()
    }
}