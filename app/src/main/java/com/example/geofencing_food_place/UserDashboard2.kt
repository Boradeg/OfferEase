package com.example.geofencing_food_place

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class UserDashboard2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_dashboard2)
        val bottom = findViewById<BottomNavigationView>(R.id.bottom2)
        replaceFragment(ShopOfferFragment())
        bottom.setOnNavigationItemSelectedListener {
            when(it.itemId)
            {

                R.id.shop ->
                {
                    replaceFragment(ShopOfferFragment())

                    true
                }

                R.id.place ->
                {
                    replaceFragment(PlaceFragment())

                    true
                }

                R.id.food ->
                {
                    replaceFragment(FoodFragment())

                    true
                }

                R.id.notify ->
                {
//                    val i = Intent(applicationContext,popnotify::class.java)
//                    startActivity(i)
                    replaceFragment(NotificationFragment())
                    true
                }



                else -> {false}
            }
        }
    }
    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container2, fragment)
        fragmentTransaction.commit()
    }
}