package com.startup.toicoclub.ui.newest

import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.startup.toicoclub.R
import com.startup.toicoclub.data.network.model.category.Category
import com.startup.toicoclub.data.network.model.newest.Wallpaper
import com.startup.toicoclub.ui.base.BaseFragment
import com.startup.toicoclub.ui.category.CategoryContract
import com.startup.toicoclub.ui.category.CategoryPresenter
import kotlinx.android.synthetic.main.fragment_category.*
import kotlinx.android.synthetic.main.fragment_newest.*
import kotlinx.android.synthetic.main.fragment_newest.rvNewest
import java.util.*
import javax.inject.Inject
import kotlin.collections.ArrayList

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
        rvCategory.adapter = this.adapter
        //rvNewest.layoutManager = StaggeredGridLayoutManager(3, LinearLayoutManager.VERTICAL)
        rvCategory.layoutManager = LinearLayoutManager(context)
        setTouchRecyclerView()

        mPresenter.loadCategoryList()

    }

    private fun setTouchRecyclerView() {
        ItemTouchHelper(object :
            ItemTouchHelper.SimpleCallback(
                ItemTouchHelper.UP or ItemTouchHelper.DOWN or ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT,
                0
            ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                Collections.swap(categories, viewHolder.adapterPosition, target.adapterPosition)
                adapter.notifyItemMoved(viewHolder.adapterPosition, target.adapterPosition)
                return true
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }).attachToRecyclerView(rvCategory);
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