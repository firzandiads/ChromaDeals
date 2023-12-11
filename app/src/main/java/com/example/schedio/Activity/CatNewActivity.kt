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

class CatNewActivity : AppCompatActivity() {
    private lateinit var adapterPupolar: RecyclerView.Adapter<*>
    private lateinit var recyclerViewPupolar: RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_new)
        initRecyclerView()
        backButton()
    }

    private fun initRecyclerView() {
        val items = ArrayList<PopularDomain>()
        items.add(
            PopularDomain(
                "Never over",
                "Never Over shirt design signifies enduring resilience " +
                        "and perpetual determination. It often incorporates" +
                        " minimalist yet impactful elements to convey " +
                        "a message of continuous strength and perseverance.",
                "item_4", 4.2, 149.0
            )
        )
        items.add(
            PopularDomain(
                "Boss mentality pt.2",
                "A Boss Mentality shirt design promotes confidence, " +
                        "leadership, and empowerment. It features bold" +
                        " elements like strong typography and symbols " +
                        "associated with success to inspire a proactive " +
                        "and resilient mindset.",
                "item_5", 5.0, 279.0
            )
        )
        recyclerViewPupolar = findViewById(R.id.view1)
        recyclerViewPupolar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapterPupolar = PupolarAdapter(items)
        recyclerViewPupolar.adapter = adapterPupolar

    }

    private fun backButton() {
        val backBtn = findViewById<ImageView>(R.id.backBtn)
        backBtn.setOnClickListener { startActivity(Intent(this@CatNewActivity, MainActivity::class.java)) }
    }
}