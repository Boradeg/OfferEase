package com.example.geofencing_food_place

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.geofencing_food_place.databinding.ActivityMyhomeBinding

class Myhome : AppCompatActivity() {

    private lateinit var binding: ActivityMyhomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_myhome)

        binding = ActivityMyhomeBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val img2 = binding.user
        val img1 = binding.owner



        img1.setOnClickListener {
            val intent = Intent(applicationContext,login::class.java)
            startActivity(intent)
        }
        img2.setOnClickListener {
            val intent = Intent(applicationContext,UserLogin::class.java)
            startActivity(intent)
        }

    }
}