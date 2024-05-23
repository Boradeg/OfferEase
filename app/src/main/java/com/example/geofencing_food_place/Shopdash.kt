package com.example.geofencing_food_place

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.geofencing_food_place.databinding.ActivityMyhomeBinding
import com.example.geofencing_food_place.databinding.ActivityShopdashBinding

class Shopdash : AppCompatActivity() {

    private lateinit var binding: ActivityShopdashBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopdash)

        binding = ActivityShopdashBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val img1 = binding.client2
        val img2 = binding.place2
        val img3 = binding.food2



        img1.setOnClickListener {
            val intent = Intent(applicationContext,Addshop::class.java)
            startActivity(intent)
        }
        img2.setOnClickListener {
            val intent = Intent(applicationContext,Addplace::class.java)
            startActivity(intent)
        }

        img3.setOnClickListener {
            val intent = Intent(applicationContext,Addfood::class.java)
            startActivity(intent)
        }


    }
}