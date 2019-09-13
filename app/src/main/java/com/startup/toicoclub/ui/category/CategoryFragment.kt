package com.startup.toicoclub.ui.newest

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.startup.toicoclub.R
import com.startup.toicoclub.data.network.model.category.Category
import com.startup.toicoclub.data.network.model.newest.Wallpaper
import com.startup.toicoclub.ui.base.BaseFragment
import com.startup.toicoclub.ui.category.CategoryContract
import com.startup.toicoclub.ui.category.CategoryPresenter
import kotlinx.android.synthetic.main.fragment_newest.*
import javax.inject.Inject

class CategoryFragment : BaseFragment(), CategoryContract.View {

    @Inject
    lateinit var mPresenter: CategoryPresenter
    lateinit var adapter: CategoryAdapter
    var categories: ArrayList<Category> = ArrayList()

    override fun setLayout(): Int {
        return R.layout.fragment_category
    }

    override fun onInit() {
        getComponent().inject(this)
        mPresenter.attach(this)
        adapter = CategoryAdapter(categories)
        rvNewest.adapter = this.adapter
        //rvNewest.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        rvNewest.layoutManager = LinearLayoutManager(context)

        mPresenter.loadCategoryList()
    }

    override fun onReceiverData(categories: ArrayList<Category>) {
        this.categories.clear()
        this.categories.addAll(categories)
        adapter.notifyDataSetChanged()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.detach()
    }
}