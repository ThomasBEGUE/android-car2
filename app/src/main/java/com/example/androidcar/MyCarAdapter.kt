package com.example.androidcar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyCarAdapter(private var arrayList: List<Car>, var clickListener: OnCarItemClickListener) :
    RecyclerView.Adapter<MyCarAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemThumbnail: ImageView = itemView.findViewById(R.id.thumbnail_row)
        var itemBrandsModelFuel: TextView = itemView.findViewById(R.id.brands_model_fuel_formatted_row)
        var itemPrice: TextView = itemView.findViewById(R.id.price_row)
        var itemStars: RatingBar = itemView.findViewById(R.id.rating_bar_row)

        fun  bindItems(model: Car, action: OnCarItemClickListener) {
            val formattedMark = model.brands + " " + model.model + " - " + model.fuel
            itemBrandsModelFuel.text = formattedMark
            val formattedText: String = model.price.toString() + " €"
            itemPrice.text = formattedText
            itemStars.rating = model.stars

            itemView.setOnClickListener {
                action.onItemClick(model, adapterPosition)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.row, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItems(arrayList[position], clickListener)
    }
}

interface OnCarItemClickListener {
    fun onItemClick(car: Car, position: Int)
}