package com.example.chromadeals

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.chromadeals.data.MainAdapter
import com.example.chromadeals.data.remote.ApiService
import com.example.chromadeals.data.remote.UsersItem
import com.example.chromadeals.databinding.ActivityHomeBinding
import com.example.chromadeals.util.constant.BASE_URL
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Home : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    private lateinit var viewAdapter: MainAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
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

        retrofit.getUsers().enqueue(object : retrofit2.Callback<List<UsersItem>> {
            override fun onResponse(
                call: Call<List<UsersItem>>,
                response: Response<List<UsersItem>>
            ){
                if (response.isSuccessful){
                    val data = response.body()!!
                    viewAdapter = MainAdapter(baseContext, data)
                    binding.itemRv.apply {
                        layoutManager = viewManager
                        adapter = viewAdapter
                    }
                }
            }

            override fun onFailure(call: retrofit2.Call<List<UsersItem>>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
}