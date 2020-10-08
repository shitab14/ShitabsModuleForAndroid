package com.mr_mir.uiuxdesign.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.mr_mir.uiuxdesign.R
import com.mr_mir.uiuxdesign.model.InstaPost
import com.mr_mir.uiuxdesign.model.PokeHomeOption

/**
 * Created by Shitab Mir on 27,July,2020
 */
class PokeHomeOptionAdapter (var list: ArrayList<PokeHomeOption>, var context: Context): RecyclerView.Adapter<PokeHomeOptionAdapter.MyViewHolder>() {
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val ivOptionImage: ImageView = itemView.findViewById<ImageView>(R.id.ivImage) as ImageView
        val cvOption: CardView = itemView.findViewById<CardView>(R.id.cvOption) as CardView
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.layout_poke_options, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.ivOptionImage.setImageResource(list[position].image!!)
        holder.cvOption.setOnClickListener {
            Toast.makeText(context, "Click on Option $position", Toast.LENGTH_SHORT).show()
        }
    }
}