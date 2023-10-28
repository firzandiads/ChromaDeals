package com.example.chromadeals.data

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.chromadeals.R
import com.example.chromadeals.data.remote.UsersItem


class MainAdapter(var context: Context, var list: List<UsersItem>): RecyclerView.Adapter<MainAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.name_rv)
        val image: ImageView = view.findViewById(R.id.image_rv)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].login
        Glide.with(context)
            .load(list[position].avatar_url)
            .into(holder.image)
    }
}