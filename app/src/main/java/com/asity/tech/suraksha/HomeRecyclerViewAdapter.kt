package com.asity.tech.suraksha

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class HomeRecyclerViewAdapter(val cardImages : Array<String>) : RecyclerView.Adapter<HomeRecyclerViewAdapter.MyViewHolder>() {
    lateinit var context : Context
    class MyViewHolder(val view : View) : RecyclerView.ViewHolder(view) {
        val cardImage : ImageView = view.findViewById(R.id.place_imageView)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.home_item,parent,false)
        context = parent.context
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Glide.with(context).load(cardImages[position]).apply(RequestOptions().override(165, 118)).into(holder.cardImage)
    }

    override fun getItemCount(): Int {
        return cardImages.size
    }
}