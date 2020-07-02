package com.mr_mir.uiuxdesign.adapter

import android.content.Context
import android.graphics.BitmapFactory
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.mr_mir.uiuxdesign.R
import com.mr_mir.uiuxdesign.model.InstaPost

/**
 * Created by Shitab Mir on 28,June,2020
 */
class PostAdapter(var list: ArrayList<InstaPost>, var context: Context): RecyclerView.Adapter<PostAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val tvPostName: TextView = itemView.findViewById<TextView>(R.id.tvPostName) as TextView
        val tvPostLocation: TextView = itemView.findViewById<TextView>(R.id.tvPostLocation) as TextView
        val ivProfileImage: ImageView = itemView.findViewById<ImageView>(R.id.ivProfileImage) as ImageView
        val ivPostImage: ImageView = itemView.findViewById<ImageView>(R.id.ivPostImage) as ImageView

        //val ivStoryThumb: ImageView = itemView.findViewById<ImageView>(R.id.ivStoryThumb) as ImageView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_posts, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvPostName.text = list[position].name
        holder.tvPostLocation.text = list[position].location

        /*val bitmapPostImage = BitmapFactory.decodeResource(
            context.resources,
            list[position].postImage!!
        )
        val bitmapProfImage = BitmapFactory.decodeResource(
            context.resources, list[position].profImage!!
        )
        holder.ivProfileImage.setImageBitmap(bitmapProfImage)
        holder.ivPostImage.setImageBitmap(bitmapPostImage)
*/

        holder.ivProfileImage.setImageDrawable(context.resources.getDrawable(list[position].profImage!!))
        holder.ivPostImage.setImageDrawable(context.resources.getDrawable(list[position].postImage!!))
    }
}