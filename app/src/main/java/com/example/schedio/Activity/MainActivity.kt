package com.example.schedio.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.schedio.Adapter.PupolarAdapter
import com.example.schedio.Domain.PopularDomain
import com.example.schedio.R

class MainActivity : AppCompatActivity() {
    private lateinit var adapterPupolar: RecyclerView.Adapter<*>
    private lateinit var recyclerViewPupolar: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initRecyclerView()
        bottomNavigation()
    }

    private fun bottomNavigation() {
        val homeBtn = findViewById<LinearLayout>(R.id.homeBtn)
        val cartBtn = findViewById<LinearLayout>(R.id.cartBtn)
        homeBtn.setOnClickListener { startActivity(Intent(this@MainActivity, MainActivity::class.java)) }
        cartBtn.setOnClickListener { startActivity(Intent(this@MainActivity, CartActivity::class.java)) }
    }

    private fun initRecyclerView() {
        val items = ArrayList<PopularDomain>()
        items.add(
            PopularDomain(
                "Love yourself",
                "Schedio elevates online shopping with curated, " +
                        "inspiring designs for every taste. From trendy to classic, " +
                        "it's your exclusive hub for unique style. Express creativity " +
                        "through captivating designs, turning each purchase into a journey " +
                        "in limitless design. Explore diverse choices and find true satisfaction " +
                        "at Schedio – where design meets desire, creating a boundless " +
                        "shopping experience.",
                "item_1", 4.9, 149.0
            )
        )
        items.add(
            PopularDomain(
                "Boss mentality",
                "Schedio elevates online shopping with curated," +
                        " inspiring designs for every taste. From trendy to classic, " +
                        "it's your exclusive hub for unique style. Express creativity " +
                        "through captivating designs, turning each purchase into a " +
                        "journey in limitless design. Explore diverse choices and find" +
                        " true satisfaction at Schedio – where design meets desire," +
                        " creating a boundless shopping experience.",
                "item_2", 4.4, 450.0
            )
        )
        items.add(
            PopularDomain(
                "Strong outside",
                "Schedio elevates online shopping with curated, " +
                        "inspiring designs for every taste. From trendy to classic," +
                        " it's your exclusive hub for unique style. Express creativity " +
                        "through captivating designs, turning each purchase into a journey" +
                        " in limitless design. Explore diverse choices and find true " +
                        "satisfaction at Schedio – where design meets desire, creating" +
                        " a boundless shopping experience.",
                "item_3", 4.6, 279.0
            )
        )
        items.add(
            PopularDomain(
                "Never over",
                "Schedio elevates online shopping with curated," +
                        " inspiring designs for every taste. From trendy to classic," +
                        " it's your exclusive hub for unique style. Express creativity " +
                        "through captivating designs, turning each purchase into a" +
                        " journey in limitless design. Explore diverse choices and " +
                        "find true satisfaction at Schedio – where design meets desire, " +
                        "creating a boundless shopping experience.",
                "item_4", 4.2, 149.0
            )
        )
        items.add(
            PopularDomain(
                "Boss mentality pt.2",
                "Schedio elevates online shopping with curated," +
                        " inspiring designs for every taste. From trendy to classic," +
                        " it's your exclusive hub for unique style. Express creativity " +
                        "through captivating designs, turning each purchase into a " +
                        "journey in limitless design. Explore diverse choices and " +
                        "find true satisfaction at Schedio – where design meets desire," +
                        " creating a boundless shopping experience.",
                "item_5", 5.0, 279.0
            )
        )
        items.add(
            PopularDomain(
                "LIAM",
                "Schedio elevates online shopping with curated, " +
                        "inspiring designs for every taste. From trendy to classic, " +
                        "it's your exclusive hub for unique style. Express creativity " +
                        "through captivating designs, turning each purchase into a journey " +
                        "in limitless design. Explore diverse choices and find true " +
                        "satisfaction at Schedio – where design meets desire, creating" +
                        " a boundless shopping experience.",
                "item_6", 3.9, 279.0
            )
        )
        items.add(
            PopularDomain(
                "Filthy frank",
                "Schedio elevates online shopping with curated," +
                        " inspiring designs for every taste. From trendy to classic," +
                        " it's your exclusive hub for unique style. Express creativity" +
                        " through captivating designs, turning each purchase into a journey" +
                        " in limitless design. Explore diverse choices and find true " +
                        "satisfaction at Schedio – where design meets desire, creating" +
                        " a boundless shopping experience.",
                "item_7", 4.1, 149.0
            )
        )
        items.add(
            PopularDomain(
                "Bracelet",
                "Schedio elevates online shopping with curated," +
                        " inspiring designs for every taste. From trendy to classic, " +
                        "it's your exclusive hub for unique style. Express creativity " +
                        "through captivating designs, turning each purchase into a" +
                        " journey in limitless design. Explore diverse choices and " +
                        "find true satisfaction at Schedio – where design meets desire," +
                        " creating a boundless shopping experience.",
                "item_8", 4.9, 279.0
            )
        )
        items.add(
            PopularDomain(
                "Boxing",
                "Schedio elevates online shopping with curated," +
                        " inspiring designs for every taste. From trendy to classic, " +
                        "it's your exclusive hub for unique style. Express creativity " +
                        "through captivating designs, turning each purchase into a " +
                        "journey in limitless design. Explore diverse choices and " +
                        "find true satisfaction at Schedio – where design meets desire, " +
                        "creating a boundless shopping experience.",
                "item_9", 4.5, 149.0
            )
        )
        recyclerViewPupolar = findViewById(R.id.view1)
        recyclerViewPupolar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapterPupolar = PupolarAdapter(items)
        recyclerViewPupolar.adapter = adapterPupolar
    }
}


