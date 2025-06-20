package com.example.travel

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.travel.adaptor.RecentsAdapter
import com.example.travel.adaptor.TopPlacesAdapter
import com.example.travel.model.RecentsData
import com.example.travel.model.TopPlacesData

class MainActivity : AppCompatActivity() {

    private lateinit var recentRecycler: RecyclerView
    private lateinit var topPlacesRecycler: RecyclerView
    private lateinit var recentsAdapter: RecentsAdapter
    private lateinit var topPlacesAdapter: TopPlacesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recentsDataList = listOf(
            RecentsData("AM Lake", "India", "From ₹20000", R.drawable.recentimage1),
            RecentsData("Nilgiri Hills", "India", "From ₹30000", R.drawable.recentimage2),
            RecentsData("AM Lake", "India", "From ₹20000", R.drawable.recentimage1),
            RecentsData("Nilgiri Hills", "India", "From ₹30000", R.drawable.recentimage2),
            RecentsData("AM Lake", "India", "From ₹20000", R.drawable.recentimage1),
            RecentsData("Nilgiri Hills", "India", "From ₹30000", R.drawable.recentimage2)
        )

        setRecentRecycler(recentsDataList)

        // Add dummy data for top places
        val topPlacesDataList = listOf(
            TopPlacesData("Kasimir Hill", "India", "₹20000 - ₹50000", R.drawable.topplaces),
            TopPlacesData("Kasimir Hill", "India", "₹20000 - ₹50000", R.drawable.topplaces),
            TopPlacesData("Kasimir Hill", "India", "₹20000 - ₹50000", R.drawable.topplaces),
            TopPlacesData("Kasimir Hill", "India", "₹20000 - ₹50000", R.drawable.topplaces),
            TopPlacesData("Kasimir Hill", "India", "₹20000 - ₹50000", R.drawable.topplaces)
        )

        setTopPlacesRecycler(topPlacesDataList)
    }

    private fun setRecentRecycler(recentsDataList: List<RecentsData>) {
        recentRecycler = findViewById(R.id.recent_recycler)
        val layoutManager = LinearLayoutManager(this, RecyclerView.HORIZONTAL, false)
        recentRecycler.layoutManager = layoutManager
        recentsAdapter = RecentsAdapter(this, recentsDataList)
        recentRecycler.adapter = recentsAdapter
    }

    private fun setTopPlacesRecycler(topPlacesDataList: List<TopPlacesData>) {
        topPlacesRecycler = findViewById(R.id.top_places_recycler)
        val layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        topPlacesRecycler.layoutManager = layoutManager
        topPlacesAdapter = TopPlacesAdapter(this, topPlacesDataList)
        topPlacesRecycler.adapter = topPlacesAdapter
    }
}
