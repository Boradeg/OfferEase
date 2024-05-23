package com.example.geofencing_food_place

import android.content.Intent
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton

import androidx.core.content.ContextCompat

class StartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_start)
        var start = findViewById<AppCompatButton>(R.id.login_btn_start)
        start.setOnClickListener {
            startActivity(Intent(this, Myhome::class.java))
        }
        // Assuming this code is within your Activity class

// Get the support action bar
        // Assuming this code is within your Activity class

// Get the support action bar

        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, R.color.black)))


    }
}