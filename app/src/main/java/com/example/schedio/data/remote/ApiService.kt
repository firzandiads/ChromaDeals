package com.example.schedio.data.remote

import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("products") //kalo gasalah dari link API nya
    fun getProductData(): Call<MyData>


}