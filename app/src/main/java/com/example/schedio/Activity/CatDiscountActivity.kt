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

class CatDiscountActivity : AppCompatActivity() {
    private lateinit var adapterPupolar: RecyclerView.Adapter<*>
    private lateinit var recyclerViewPupolar: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cat_discount)
        initRecyclerView()
        backButton()

    }

    private fun backButton() {
        val backBtn = findViewById<ImageView>(R.id.backBtn)
        backBtn.setOnClickListener { startActivity(Intent(this@CatDiscountActivity, MainActivity::class.java)) }
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
        recyclerViewPupolar.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        adapterPupolar = PupolarAdapter(items)
        recyclerViewPupolar.adapter = adapterPupolar
    }
}