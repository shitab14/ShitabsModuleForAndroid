package com.mr_mir.shitabsmoduleforandroid.adapters

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.recyclerview.widget.RecyclerView
import com.mr_mir.shitabsmoduleforandroid.R

/**
 * Created by Shitab Mir on 06,May,2020
 */
class ActionsAdapter(var list: ArrayList<String>, var context: Context): RecyclerView.Adapter<ActionsAdapter.MyViewHolder>(){
    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val button: Button = itemView.findViewById<Button>(R.id.buttonView) as Button
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.module_rv_button, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.button.text = list[position]
        holder.button.setOnClickListener(View.OnClickListener {

        })
    }

}