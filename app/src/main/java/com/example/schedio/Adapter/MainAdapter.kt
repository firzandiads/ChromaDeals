package com.example.schedio.Adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.schedio.R
import com.example.schedio.data.remote.Product
import com.squareup.picasso.Picasso

class MainAdapter(val context: Activity, val productArrayList:List<Product>):
    RecyclerView.Adapter<MainAdapter.MyViewHolder>(){
    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val price: TextView
        var title:TextView
        var image: ImageView
        var ratingBar: TextView
        init {
            title=itemView.findViewById(R.id.name_rv)
            image=itemView.findViewById(R.id.image_rv)
            ratingBar=itemView.findViewById(R.id.rating_rv)
            price=itemView.findViewById(R.id.price_rv)


        }
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView=LayoutInflater.from(context).inflate(R.layout.eachitem,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return productArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem= productArrayList[position]
        holder.title.text=currentItem.title

        Picasso.get().load(currentItem.thumbnail).into(holder.image)
        holder.ratingBar.text= currentItem.rating.toString()
        holder.price.text= currentItem.price.toString()

    }
}