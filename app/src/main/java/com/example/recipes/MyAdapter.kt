package com.example.recipes

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.squareup.picasso.Picasso

class MyAdapter(val context: Activity, val recipiArrayList: List<Recipe>):
    RecyclerView.Adapter<MyAdapter.MyViewHolder>() {

    class MyViewHolder(itemView:View):RecyclerView.ViewHolder(itemView) {
        val name : TextView
        val cuisin : TextView
        val image : ShapeableImageView

        init {
            name = itemView.findViewById(R.id.recipiName)
            cuisin = itemView.findViewById(R.id.recipiCuisin)
            image = itemView.findViewById(R.id.recipiImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = LayoutInflater.from(context).inflate(R.layout.recepis_list,parent,false)
        return MyViewHolder(itemView)
    }

    override fun getItemCount(): Int {
        return recipiArrayList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentRecipi = recipiArrayList[position]
        holder.name.text = currentRecipi.name
        holder.cuisin.text = currentRecipi.cuisine
        Picasso.get().load(currentRecipi.image).into(holder.image);

    }
}