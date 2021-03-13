package com.example.androidcar

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyCarAdapter(private val arrayList: ArrayList<Car>, val context: Context) :
    RecyclerView.Adapter<MyCarAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var itemImage: ImageView = itemView.findViewById(R.id.imageIv)
        var itemTitle: TextView = itemView.findViewById(R.id.titleTv)
        var itemDescription: TextView = itemView.findViewById(R.id.descriptionTv)

        fun  bindItems(model: Car) {
            itemTitle.text = model.title
            itemDescription.text = model.description
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
        holder.bindItems(arrayList[position])
    }
}