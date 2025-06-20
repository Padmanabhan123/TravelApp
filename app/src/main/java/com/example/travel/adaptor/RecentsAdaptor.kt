package com.example.travel.adaptor

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.travel.DetailsActivity
import com.example.travel.R
import com.example.travel.model.RecentsData

class RecentsAdapter(
    private val context: Context,
    private val recentsDataList: List<RecentsData>
) : RecyclerView.Adapter<RecentsAdapter.RecentsViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecentsViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recents_row_item, parent, false)
        return RecentsViewHolder(view)
    }

    override fun onBindViewHolder(holder: RecentsViewHolder, position: Int) {
        val item = recentsDataList[position]

        holder.countryName.text = item.countryName
        holder.placeName.text = item.placeName
        holder.price.text = "₹Rs{item.price}"
        holder.placeImage.setImageResource(item.imageUrl)

        holder.itemView.setOnClickListener {
            val intent = Intent(context, DetailsActivity::class.java)
            context.startActivity(intent)
        }
    }

    override fun getItemCount(): Int = recentsDataList.size

    class RecentsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val placeImage: ImageView = itemView.findViewById(R.id.place_image)
        val placeName: TextView = itemView.findViewById(R.id.place_name)
        val countryName: TextView = itemView.findViewById(R.id.country_name)
        val price: TextView = itemView.findViewById(R.id.price)
    }
}
