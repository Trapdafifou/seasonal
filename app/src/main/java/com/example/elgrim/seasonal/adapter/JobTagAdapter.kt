package com.example.elgrim.seasonal.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.elgrim.seasonal.R
import kotlinx.android.synthetic.main.job_tag_item.view.*


class JobTagAdapter(val items : ArrayList<String>, val context: Context) : RecyclerView.Adapter<ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.job_tag_item, parent, false))

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder?.jobTagType?.textOn = items.get(position)
        holder?.jobTagType?.textOff = items.get(position)
        holder?.jobTagType?.text = items.get(position)
        println(holder?.jobTagType)
    }


    override fun getItemCount(): Int {
        return items.size
    }

}

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {
    // Holds the TextView that will add each animal to
    val jobTagType = view.jobTagButton
}