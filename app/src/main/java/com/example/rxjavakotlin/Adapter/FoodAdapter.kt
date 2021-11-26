package com.example.rxjavakotlin.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.rxjavakotlin.Model.Food
import com.example.rxjavakotlin.R

class FoodAdapter(private val context: Context, private var foodList: ArrayList<Food>) :
    RecyclerView.Adapter<FoodAdapter.FoodViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FoodViewHolder {
        return FoodViewHolder(
            LayoutInflater.from(context).inflate(R.layout.each_row, parent, false)
        )
    }

    override fun onBindViewHolder(holder: FoodViewHolder, position: Int) {
        val food = foodList[position]
        holder.name.text = food.name
        holder.price.text = food.price.toString()
        Glide.with(context)
            .load(food.image)
            .into(holder.image)
    }

    fun setData(foodList: ArrayList<Food>) {
        this.foodList = foodList
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = foodList.size

    inner class FoodViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val image: ImageView = itemView.findViewById(R.id.image)
        val price: TextView = itemView.findViewById(R.id.price)
    }
}