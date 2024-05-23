package com.example.geofencing_food_place

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geofencing_food_place.databinding.FragmentFoodBinding
import com.example.geofencing_food_place.databinding.FragmentPlaceBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.Query
import com.google.firebase.database.ValueEventListener


class FoodFragment : Fragment() {
    private var database: FirebaseDatabase? = null
    private var ref: DatabaseReference? = null
    private var adapter: MyAdapter? = null
    private var list: ArrayList<MyShop>? = null
    private lateinit var binding: FragmentFoodBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentFoodBinding.inflate(layoutInflater)
        binding.openMapButton.setOnClickListener {
            replaceFragment(FoodLocationFragment())
        }
        val recyclerView = binding.recyclerview
        recyclerView.setHasFixedSize(true)
        recyclerView.layoutManager = LinearLayoutManager(requireContext())
        list = ArrayList()
        database = FirebaseDatabase.getInstance()
        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("Food")
        //val query: Query = mDatabaseRef.orderByChild("Address").equalTo(str)
        mDatabaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                print(dataSnapshot)
                for (data in dataSnapshot.children) {
                    println(data)
                    val models: MyShop? = data.getValue(MyShop::class.java)
                    println(models)
                    if (models != null) {
                        list!!.add(models)
                    }
                }
                adapter = MyAdapter(list, requireContext())
                recyclerView.adapter = adapter
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })

        // Inflate the layout for this fragment
        return binding.root
    }

    private fun replaceFragment(fragment: Fragment) {
        val fragmentManager = parentFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragment_container2, fragment)
        fragmentTransaction.addToBackStack(null) // Optional: add to back stack if you want to allow users to navigate back
        fragmentTransaction.commit()
    }

}