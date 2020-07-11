package com.mcssoft.racedayreminder.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.mcssoft.racedayreminder.R

class RaceDayAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        Log.d("TAG","RaceDetailsAdapter.onCreateViewHolder")
        val view: View =
            LayoutInflater.from(parent.context).inflate(R.layout.row_race_details, parent, false)
        return RaceDayViewHolder(view)
    }

    override fun getItemCount(): Int {
        // TBA
        return 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        //
    }
}