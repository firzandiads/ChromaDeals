package com.example.schedio.Activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ScrollView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schedio.Adapter.CartAdapter
import com.example.schedio.Helper.ManagmentCart
import com.example.schedio.Login.DeliveredActivity
import com.example.schedio.R
import kotlin.math.roundToInt

class CartActivity : AppCompatActivity() {
    private lateinit var adapter: RecyclerView.Adapter<*>
    private lateinit var recyclerView: RecyclerView
    private lateinit var managmentCart: ManagmentCart
    private lateinit var totalFeeTxt: TextView
    private lateinit var taxTxt: TextView
    private lateinit var deliveryTxt: TextView
    private lateinit var totalTxt: TextView
    private lateinit var emptyTxt: TextView
    private var tax: Double = 0.0
    private lateinit var scrollView: ScrollView
    private lateinit var backBtn: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cart)
        managmentCart = ManagmentCart(this)
        initView()
        setVariable()
        calculateCart()
        initList()
    }

    private fun initList() {
        if (managmentCart.getListCart().isEmpty()) {
            emptyTxt.visibility = View.VISIBLE
            scrollView.visibility = View.GONE
        } else {
            emptyTxt.visibility = View.GONE
            scrollView.visibility = View.VISIBLE
        }
        val linearLayoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerView.layoutManager = linearLayoutManager
        adapter = CartAdapter(managmentCart.getListCart(), this) { calculateCart() }
        recyclerView.adapter = adapter
    }

    private fun calculateCart() {
        val percentTax = 0.01
        val delivery = 7.0
        tax = (managmentCart.getTotalFee() * percentTax * 100.0).roundToInt() / 100.0
        val total = ((managmentCart.getTotalFee() + tax + delivery) * 100).roundToInt() / 100.0
        val itemTotal = (managmentCart.getTotalFee() * 100).roundToInt() / 100.0
        totalFeeTxt.text = "Rp$itemTotal"
        taxTxt.text = "Rp$tax"
        deliveryTxt.text = "Rp$delivery"
        totalTxt.text = "Rp$total"
    }

    private fun setVariable() {
        backBtn.setOnClickListener { finish() }
        val button: Button = findViewById(R.id.button)
        button.setOnClickListener {
            val intent = Intent(this@CartActivity, DeliveredActivity::class.java)
            startActivity(intent)
        }
    }

    private fun initView() {
        totalFeeTxt = findViewById(R.id.totalFeeTxt)
        taxTxt = findViewById(R.id.taxTxt)
        deliveryTxt = findViewById(R.id.deliveryTxt)
        totalTxt = findViewById(R.id.totalTxt)
        recyclerView = findViewById(R.id.view2)
        scrollView = findViewById(R.id.scrollView2)
        backBtn = findViewById(R.id.backBtn)
        emptyTxt = findViewById(R.id.emptyTxt)
    }
}


