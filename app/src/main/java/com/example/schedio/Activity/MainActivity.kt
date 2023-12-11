package com.example.schedio.Activity

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
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
        //val homeBtn = findViewById<LinearLayout>(R.id.homeBtn)
        val cartBtn = findViewById<LinearLayout>(R.id.cartBtn)
        val otherBtn = findViewById<LinearLayout>(R.id.otherBtn)
        val profileBtn = findViewById<LinearLayout>(R.id.profileBtn)
        val aboutBtn = findViewById<ImageView>(R.id.aboutBtn)



        //homeBtn.setOnClickListener { startActivity(Intent(this@MainActivity, MainActivity::class.java)) }
        cartBtn.setOnClickListener { startActivity(Intent(this@MainActivity, CartActivity::class.java)) }
        otherBtn.setOnClickListener { startActivity(Intent(this@MainActivity, OtherActivity::class.java)) }
        profileBtn.setOnClickListener { startActivity(Intent(this@MainActivity, ProfileActivity::class.java)) }
        aboutBtn.setOnClickListener { startActivity(Intent(this@MainActivity, AboutActivity::class.java)) }


    }

    private fun initRecyclerView() {
        val items = ArrayList<PopularDomain>()
        items.add(
            PopularDomain(
                "Love yourself",
                "Designing a Love Yourself themed shirt involves" +
                        " creating a visual representation that promotes" +
                        " self-love and acceptance. This design typically " +
                        "incorporates positive and uplifting elements" +
                        " such as inspiring quotes, heart symbols, or" +
                        " empowering imagery. The goal is to convey a " +
                        "message of self-appreciation and confidence, " +
                        "encouraging individuals to embrace their unique " +
                        "qualities and love themselves just the way they are.",
                "item_1", 4.9, 149.0
            )
        )
        items.add(
            PopularDomain(
                "Boss mentality",
                "A Boss Mentality shirt design promotes confidence," +
                        " leadership, and empowerment. It features bold elements" +
                        " like strong typography and symbols associated " +
                        "with success to inspire a proactive and resilient mindset.",
                "item_2", 4.4, 450.0
            )
        )
        items.add(
            PopularDomain(
                "Strong outside",
                "Strong Outside shirt design emphasizes resilience " +
                        "and toughness. It typically includes bold visuals or " +
                        "text to convey a powerful and robust image, encouraging " +
                        "a sense of inner strength and durability.",
                "item_3", 4.6, 279.0
            )
        )
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
        items.add(
            PopularDomain(
                "Bracelet",
                "A Bracelet themed design highlights the elegance and " +
                        "simplicity of wrist accessories. The design may feature " +
                        "artistic representations of bracelets, intricate patterns, " +
                        "or stylish minimalism to appeal to those who appreciate " +
                        "fashionable wristwear.",
                "item_8", 4.9, 279.0
            )
        )
        items.add(
            PopularDomain(
                "Boxing",
                "\n" +
                        "A \"Boxing\" themed shirt design embodies the intensity and " +
                        "strength of the sport. It could showcase dynamic images of boxers," +
                        " gloves, and a bold color palette to convey the energy and passion" +
                        " of boxing.",
                "item_9", 4.5, 149.0
            )
        )
        recyclerViewPupolar = findViewById(R.id.view1)
        recyclerViewPupolar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        adapterPupolar = PupolarAdapter(items)
        recyclerViewPupolar.adapter = adapterPupolar
    }
}


