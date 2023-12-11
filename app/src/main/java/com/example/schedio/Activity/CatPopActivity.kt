package com.example.schedio.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schedio.Adapter.PupolarAdapter
import com.example.schedio.Domain.PopularDomain
import com.example.schedio.R

class CatPopActivity : AppCompatActivity() {
    private lateinit var adapterPupolar: RecyclerView.Adapter<*>
    private lateinit var recyclerViewPupolar: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_pop)
        initRecyclerView()
        backButton()

    }

    private fun initRecyclerView() {
        val items = ArrayList<PopularDomain>()
        items.add(
            PopularDomain(
                "LIAM",
                "A Liam Gallagher shirt design captures the " +
                        "rock 'n' roll spirit with bold typography, " +
                        "Oasis references, and a rebellious vibe.",
                "item_6", 3.9, 279.0
            )
        )
        items.add(
            PopularDomain(
                "Filthy frank",
                "Filthy Frank shirt design captures the irreverent" +
                        " and comedic style of the popular internet personality. " +
                        "It might feature quirky illustrations, inside jokes," +
                        " or iconic phrases associated with Filthy Frank's" +
                        " unique content and persona.",
                "item_7", 4.1, 149.0
            )
        )
        recyclerViewPupolar = findViewById(R.id.view1)
        recyclerViewPupolar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapterPupolar = PupolarAdapter(items)
        recyclerViewPupolar.adapter = adapterPupolar

    }

    private fun backButton() {
        val backBtn = findViewById<ImageView>(R.id.backBtn)
        backBtn.setOnClickListener { startActivity(Intent(this@CatPopActivity, MainActivity::class.java)) }
    }
}