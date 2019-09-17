package com.startup.toicoclub.ui.newest

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mindorks.framework.mvp.util.extension.loadImage
import com.startup.toicoclub.data.network.model.newest.Wallpaper
import kotlinx.android.synthetic.main.item_newest.view.*
import java.util.*
import kotlin.collections.ArrayList
import java.util.Collections.swap
import android.R


class NewestAdapter(arrayList: ArrayList<Wallpaper>) :
    RecyclerView.Adapter<NewestAdapter.ViewHolder>() {

    var wallpaperList: ArrayList<Wallpaper> = arrayList

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        var view: View =
            LayoutInflater.from(parent.context).inflate(com.startup.toicoclub.R.layout.item_newest, parent, false)
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

    public fun onMove(positionFrom: Int, positionTo: Int) {
        if (positionFrom < positionTo) {
            for (i in positionFrom until positionTo) {
                Collections.swap(wallpaperList, i, i + 1)
            }
        } else {
            for (i in positionFrom downTo positionTo + 1) {
                Collections.swap(wallpaperList, i, i - 1)
            }
        }
        notifyItemMoved(positionFrom, positionTo)
    }

    public fun onSwipe(position: Int, direction: Int) {
        wallpaperList.remove(wallpaperList[position])
        notifyItemRemoved(position)
    }
}