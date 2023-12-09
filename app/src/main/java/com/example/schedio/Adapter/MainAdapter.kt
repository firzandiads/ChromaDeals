package com.example.schedio.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.schedio.R
import com.example.schedio.data.remote.Product


class MainAdapter(var context: Context, var list: List<Product>): RecyclerView.Adapter<MainAdapter.ViewHolder>(){
    inner class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val name: TextView = view.findViewById(R.id.name_rv)
        val image: ImageView = view.findViewById(R.id.image_rv)
        val rating: TextView = view.findViewById(R.id.rating_rv)
        val price: TextView = view.findViewById(R.id.price_rv)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.name.text = list[position].title
        holder.rating.text = list[position].rating.toString()
        holder.price.text = list[position].price.toString()
        Glide.with(context)
            .load(list[position].thumbnail)
            .into(holder.image)

    }
}