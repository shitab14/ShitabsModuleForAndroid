package com.mr_mir.uiuxdesign.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.mr_mir.uiuxdesign.R


/**
 * Created by Shitab Mir on 28,June,2020
 */
class StoryAdapter(var list: ArrayList<Int>, var context: Context): RecyclerView.Adapter<StoryAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val ivStoryThumb: ImageView = itemView.findViewById<ImageView>(R.id.ivStoryThumb) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_stories, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {


        holder.ivStoryThumb.setImageDrawable(context.resources.getDrawable(list[position]))
        /*val bitmap = BitmapFactory.decodeResource(
            context.resources,
            list[position]
        )
        holder.ivStoryThumb.setImageBitmap(bitmap)*/

    }
}
