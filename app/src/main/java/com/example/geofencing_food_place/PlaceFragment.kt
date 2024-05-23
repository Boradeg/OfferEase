package com.example.geofencing_food_place

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.geofencing_food_place.databinding.FragmentPlaceBinding
import com.example.geofencing_food_place.databinding.FragmentShopOfferBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class PlaceFragment : Fragment() {
    private lateinit var binding: FragmentPlaceBinding

    private var database: FirebaseDatabase? = null
    private var ref: DatabaseReference? = null
    private var adapter: PlaceAdapter? = null
    private var list: ArrayList<MyPlace>? = null
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding=FragmentPlaceBinding.inflate(layoutInflater)
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        list = ArrayList()
        database = FirebaseDatabase.getInstance()
        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("Place")
        // val query: Query = mDatabaseRef.orderByChild("address").equalTo(str)
        mDatabaseRef.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                print(dataSnapshot)
                for (data in dataSnapshot.children) {
                    println(data)
                    val models: MyPlace? = data.getValue(MyPlace::class.java)
                    println(models)
                    if (models != null) {
                        list!!.add(models)
                    }
                }
                adapter = PlaceAdapter(list, requireContext())
                binding.recyclerview.adapter = adapter
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })
        // Inflate the layout for this fragment
        return binding.root
    }


}