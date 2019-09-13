package com.startup.toicoclub.ui.newest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvp.util.extension.loadImage
import com.startup.toicoclub.R
import com.startup.toicoclub.data.network.model.newest.Wallpaper
import kotlinx.android.synthetic.main.item_newest.view.*

class NewestAdapter(arrayList: ArrayList<Wallpaper>) :
    RecyclerView.Adapter<NewestAdapter.ViewHolder>() {

    var wallpaperList: ArrayList<Wallpaper> = arrayList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View = LayoutInflater.from(parent.context).inflate(R.layout.item_newest, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = wallpaperList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(wallpaperList[position])
    }

    class ViewHolder(item: View) : RecyclerView.ViewHolder(item) {
        var ivImage: ImageView = item.ivImage
        fun bind(wallpaper: Wallpaper) {
            ivImage.loadImage(wallpaper.urlImage)
        }
    }
}