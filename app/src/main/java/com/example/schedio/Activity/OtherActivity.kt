package com.example.schedio.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schedio.Adapter.MainAdapter
import com.example.schedio.R
import com.example.schedio.data.remote.ApiService
import com.example.schedio.data.remote.MyData
import com.facebook.shimmer.ShimmerFrameLayout
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OtherActivity : AppCompatActivity() {
    lateinit var recyclerView: RecyclerView
    lateinit var mainAdapter: MainAdapter
    lateinit var shimmerFrameLayout: ShimmerFrameLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_other)

        recyclerView=findViewById(R.id.item_rv)
        shimmerFrameLayout=findViewById(R.id.shimmer)
        bottomNavigation()


        val retrofitBuilder= Retrofit.Builder()
            .baseUrl("https://dummyjson.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        val retrofitData= retrofitBuilder.getProductData()

        retrofitData.enqueue(object : Callback<MyData?> {
            override fun onResponse(call: Call<MyData?>, response: Response<MyData?>) {
                // if api call is success,then use the data of API and show in android app
                val responseBody=response.body()
                val productList= responseBody?.products!!

                mainAdapter= MainAdapter(this@OtherActivity,productList)

                recyclerView.adapter=mainAdapter
                shimmerFrameLayout.stopShimmer()
                shimmerFrameLayout.setVisibility(View.GONE)
                recyclerView.setVisibility(View.VISIBLE)

                recyclerView.layoutManager=LinearLayoutManager(this@OtherActivity)
            }

            override fun onFailure(call: Call<MyData?>, t: Throwable) {
                // if api call is fails

                Log.d("OtherActivity","OnFailure"+t.message)

            }
        })
    }

    private fun bottomNavigation() {
        val homeBtn = findViewById<LinearLayout>(R.id.homeBtn)
        val cartBtn = findViewById<LinearLayout>(R.id.cartBtn)
        //val otherBtn = findViewById<LinearLayout>(R.id.otherBtn)
        val profileBtn = findViewById<LinearLayout>(R.id.profileBtn)


        homeBtn.setOnClickListener { startActivity(Intent(this@OtherActivity, MainActivity::class.java)) }
        cartBtn.setOnClickListener { startActivity(Intent(this@OtherActivity, CartActivity::class.java)) }
        //otherBtn.setOnClickListener { startActivity(Intent(this@OtherActivity, OtherActivity::class.java)) }
        profileBtn.setOnClickListener { startActivity(Intent(this@OtherActivity, ProfileActivity::class.java)) }

    }
}