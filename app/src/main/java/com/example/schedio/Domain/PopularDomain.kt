package com.example.schedio.Domain

import java.io.Serializable

data class PopularDomain(
    var title: String,
    var description: String,
    var picUrl: String,
    var score: Double,
    var price: Double
) : Serializable {
    var numberInCart: Int = 0
}


