package com.example.schedio.data.remote

data class Users(
    val limit: Int,
    val products: List<Product>,
    val skip: Int,
    val total: Int,

)