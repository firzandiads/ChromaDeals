package com.example.schedio.Adapter

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.example.schedio.Activity.DetailActivity
import com.example.schedio.Domain.PopularDomain
import com.example.schedio.R

class PupolarAdapter(private val items: ArrayList<PopularDomain>) : RecyclerView.Adapter<PupolarAdapter.Viewholder>() {
    private lateinit var context: Context

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        context = parent.context
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_pup_list, parent, false)
        return Viewholder(inflate)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.titleTxt.text = items[position].title
        holder.feeTxt.text = "Rp" + items[position].price
        val drawableResourceId = holder.itemView.resources.getIdentifier(items[position].picUrl,
            "drawable", holder.itemView.context.packageName)
        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .transform(GranularRoundedCorners(30F, 30F, 0F, 0F))
            .into(holder.pic)
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, DetailActivity::class.java)
            intent.putExtra("object", items[position])
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTxt: TextView = itemView.findViewById(R.id.titleTxt)
        val feeTxt: TextView = itemView.findViewById(R.id.feeTxt)
        val pic: ImageView = itemView.findViewById(R.id.pic)
    }
}


