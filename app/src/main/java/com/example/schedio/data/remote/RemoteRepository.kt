package com.example.schedio.data.remote

class RemoteRepository (private val apiService: ApiService){
    fun getUsers() = apiService.getProductData()
}