package com.example.schedio.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners
import com.example.schedio.Domain.PopularDomain
import com.example.schedio.Helper.ChangeNumberItemsListener
import com.example.schedio.Helper.ManagmentCart
import com.example.schedio.R

class CartAdapter(
    private val listItemSelected: ArrayList<PopularDomain>,
    private val context: Context,
    private val changeNumberItemsListener: ChangeNumberItemsListener
) : RecyclerView.Adapter<CartAdapter.Viewholder>() {

    private val managmentCart: ManagmentCart = ManagmentCart(context)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Viewholder {
        val inflate = LayoutInflater.from(parent.context).inflate(R.layout.viewholder_cart, parent, false)
        return Viewholder(inflate)
    }

    override fun onBindViewHolder(holder: Viewholder, position: Int) {
        holder.title.text = listItemSelected[position].title
        holder.feeEachItem.text = "$" + listItemSelected[position].price
        holder.totalEachItem.text = "$" + (listItemSelected[position].numberInCart * listItemSelected[position].price).toLong()
        holder.num.text = listItemSelected[position].numberInCart.toString()

        val drawableResourceId = holder.itemView.context.resources.getIdentifier(
            listItemSelected[position].picUrl,
            "drawable",
            holder.itemView.context.packageName
        )
        Glide.with(holder.itemView.context)
            .load(drawableResourceId)
            .transform(GranularRoundedCorners(30f, 30f, 30f, 30f))
            .into(holder.pic)

        holder.plusItem.setOnClickListener {
            managmentCart.plusNumberItem(listItemSelected, position) {
                notifyDataSetChanged()
                changeNumberItemsListener.change()
            }
        }

        holder.minusItem.setOnClickListener {
            managmentCart.minusNumberItem(listItemSelected, position) {
                notifyDataSetChanged()
                changeNumberItemsListener.change()
            }
        }
    }

    override fun getItemCount(): Int {
        return listItemSelected.size
    }

    inner class Viewholder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.titleTxt)
        val pic: ImageView = itemView.findViewById(R.id.pic)
        val feeEachItem: TextView = itemView.findViewById(R.id.feeEachItem)
        val totalEachItem: TextView = itemView.findViewById(R.id.totalEachItem)
        val plusItem: TextView = itemView.findViewById(R.id.plusCartBtn)
        val minusItem: TextView = itemView.findViewById(R.id.minusCartBtn)
        val num: TextView = itemView.findViewById(R.id.numberItemTxt)
    }
}


