package com.example.schedio.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewManager
import android.widget.LinearLayout
//import androidx.compose.ui.node.ViewAdapter
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schedio.Adapter.MainAdapter
import com.example.schedio.R
import com.example.schedio.data.remote.ApiService
import com.example.schedio.data.remote.Product
import com.example.schedio.databinding.ActivityOtherBinding
import com.example.schedio.util.constant.BASE_URL
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class OtherActivity : AppCompatActivity() {


    private lateinit var binding: ActivityOtherBinding
    private lateinit var viewAdapter: MainAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityOtherBinding.inflate(layoutInflater)
        //setContentView(R.layout.activity_other)
        setContentView(binding.root)

        viewManager = LinearLayoutManager(this)
        getUsersData()


    }

    private fun getUsersData() {
        var retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)

        retrofit.getUsers().enqueue(object : retrofit2.Callback<List<Product>> {
            override fun onResponse(
                call: Call<List<Product>>,
                response: Response<List<Product>>
            ) {
                if (response.isSuccessful) {
                    val data = response.body()!!
                    viewAdapter = MainAdapter(baseContext, data)
                    binding.itemRv.apply {
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<List<Product>>, t: Throwable) {
                t.printStackTrace()
            }
        })

    }
}