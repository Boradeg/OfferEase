package com.example.geofencing_food_place

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.denzcoskun.imageslider.ImageSlider
import com.denzcoskun.imageslider.constants.ScaleTypes
import com.denzcoskun.imageslider.models.SlideModel
import com.example.geofencing_food_place.databinding.FragmentShopOfferBinding
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

class ShopOfferFragment : Fragment() {
//
    private var database: FirebaseDatabase? = null
    private var ref: DatabaseReference? = null
    private var adapter:MyAdapter?=null
    private var list: ArrayList<MyShop>? = null
    private lateinit var binding:FragmentShopOfferBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding=FragmentShopOfferBinding.inflate(layoutInflater)
        val imageSlider = binding.imgSlider
        val slideModels = java.util.ArrayList<SlideModel>()

        slideModels.add(SlideModel(R.drawable.image_offer2, ScaleTypes.CENTER_INSIDE))
        slideModels.add(SlideModel(R.drawable.img_for_slider, ScaleTypes.FIT))
        slideModels.add(SlideModel(R.drawable.image_offer1, ScaleTypes.CENTER_INSIDE))
//        slideModels.add(SlideModel(R.drawable.homework3, ScaleTypes.FIT))
//        slideModels.add(SlideModel(R.drawable.school2, ScaleTypes.CENTER_INSIDE))
//        slideModels.add(SlideModel(R.drawable.studens, ScaleTypes.FIT))

        imageSlider.setImageList(slideModels, ScaleTypes.FIT)
        binding.recyclerview.setHasFixedSize(true)
        binding.recyclerview.layoutManager = LinearLayoutManager(requireContext())
        list = ArrayList()

        database = FirebaseDatabase.getInstance()
        val mDatabaseRef = FirebaseDatabase.getInstance().getReference("Shop")
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
                adapter = MyAdapter(list,requireContext())
                binding.recyclerview.adapter = adapter
            }
            override fun onCancelled(databaseError: DatabaseError) {}
        })
        return binding.root

    }


}