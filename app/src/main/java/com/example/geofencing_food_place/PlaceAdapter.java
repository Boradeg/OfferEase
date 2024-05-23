package com.example.geofencing_food_place;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.ViewHolder>{
    ArrayList<MyPlace> mList;
    Context context;

    public PlaceAdapter(ArrayList<MyPlace> mList, Context context) {
        this.mList = mList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_dummy,parent,false);

        return new PlaceAdapter.ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
       MyPlace vacancy1 = mList.get(position);
        holder.place_name.setText("Place Name "+vacancy1.name);
        holder.address.setText("History "+vacancy1.history);
       // holder.txttype.setText("Time "+vacancy1.time);




        Glide.with(holder.place_img.getContext()).load(vacancy1.getImageurl()).into(holder.place_img);
        holder.relativeLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(v.getContext(), Placedetails.class);

                intent.putExtra("sname", vacancy1.getName());
                intent.putExtra("address",vacancy1.getAddress());
                intent.putExtra("number",vacancy1.getHistory());
                intent.putExtra("product1",vacancy1.getTime());
                intent.putExtra("offer",vacancy1.getLandmark());
//                intent.putExtra("product2",vacancy1.getProduct2());
//                intent.putExtra("offer2",vacancy1.getOffer2());
                intent.putExtra("url",vacancy1.getImageurl());
                v.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView place_img;
        TextView place_name,address;

        RelativeLayout relativeLayout;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            place_img =itemView.findViewById(R.id.shop_img);
            place_name = itemView.findViewById(R.id.shop_name);
            address = itemView.findViewById(R.id.address);
//            txttype = itemView.findViewById(R.id.emailtext);
            relativeLayout = itemView.findViewById(R.id.rel_l);

        }
    }
}
