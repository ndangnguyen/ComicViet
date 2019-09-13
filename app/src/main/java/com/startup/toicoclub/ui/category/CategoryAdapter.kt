package com.startup.toicoclub.ui.newest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvp.util.extension.loadImage
import com.startup.toicoclub.R
import com.startup.toicoclub.data.network.model.category.Category
import kotlinx.android.synthetic.main.item_category.view.*

class CategoryAdapter(arrayList: ArrayList<Category>) :
    RecyclerView.Adapter<CategoryAdapter.ViewHolder>() {

    var categoryList: ArrayList<Category> = arrayList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.item_category, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = categoryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(categoryList[position])
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var ivImage: ImageView = item.ivImage
        var tvName: TextView = item.tvName
        var tvCount: TextView = item.tvCount
        fun bind(category: Category) {
            tvName.text = category.name
            tvCount.text = category.count.toString()

            //ivImage.loadImage(category.thumbURL)
        }
    }
}