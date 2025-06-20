package com.example.travel.adaptor

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travel.R
import com.example.travel.model.TopPlacesData

class TopPlacesAdapter(
    private val context: Context,
    private val topPlacesDataList: List<TopPlacesData>
) : RecyclerView.Adapter<TopPlacesAdapter.TopPlacesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopPlacesViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.top_places_row_item, parent, false)
        return TopPlacesViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopPlacesViewHolder, position: Int) {
        val item = topPlacesDataList[position]
        holder.countryName.text = item.countryName
        holder.placeName.text = item.placeName
        holder.price.text = "₹${item.price}"
        holder.placeImage.setImageResource(item.imageUrl)
    }

    override fun getItemCount(): Int = topPlacesDataList.size

    class TopPlacesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val placeImage: ImageView = itemView.findViewById(R.id.place_image)
        val placeName: TextView = itemView.findViewById(R.id.place_name)
        val countryName: TextView = itemView.findViewById(R.id.country_name)
        val price: TextView = itemView.findViewById(R.id.price)
    }
}
