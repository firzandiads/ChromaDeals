package com.example.schedio.Activity

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.schedio.Domain.PopularDomain
import com.example.schedio.Helper.ManagmentCart
import com.example.schedio.R

class DetailActivity : AppCompatActivity() {
    private lateinit var addToCartBtn: Button
    private lateinit var titleTxt: TextView
    private lateinit var feeTxt: TextView
    private lateinit var descriptionTxt: TextView
    private lateinit var scoreTxt: TextView
    private lateinit var picItem: ImageView
    private lateinit var backBtn: ImageView
    private lateinit var itemObject: PopularDomain
    private var numberOrder = 1
    private lateinit var managmentCart: ManagmentCart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)
        managmentCart = ManagmentCart(this)
        initView()
        getBundle()
    }

    private fun getBundle() {
        itemObject = intent.getSerializableExtra("object") as PopularDomain
        val drawableResourceId = resources.getIdentifier(itemObject.picUrl, "drawable", packageName)
        Glide.with(this)
            .load(drawableResourceId)
            .into(picItem)
        titleTxt.text = itemObject.title
        feeTxt.text = "$" + itemObject.price
        descriptionTxt.text = itemObject.description
        scoreTxt.text = itemObject.score.toString()
        addToCartBtn.setOnClickListener {
            itemObject.numberInCart = numberOrder
            managmentCart.insertFood(itemObject)
        }
        backBtn.setOnClickListener { finish() }
    }

    private fun initView() {
        addToCartBtn = findViewById(R.id.addToCartBtn)
        feeTxt = findViewById(R.id.priceTxt)
        titleTxt = findViewById(R.id.titleTxt)
        descriptionTxt = findViewById(R.id.descriptionTxt)
        picItem = findViewById(R.id.itemPic)
        scoreTxt = findViewById(R.id.scoreTxt)
        backBtn = findViewById(R.id.backBtn)
    }
}


