package com.mcssoft.racedayreminder.adapter

import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.PopupMenu
import androidx.recyclerview.widget.RecyclerView

class RaceDayViewHolder(private val view: View) : RecyclerView.ViewHolder(view),
    View.OnClickListener, PopupMenu.OnMenuItemClickListener {

    override fun onClick(v: View?) {
        // TBA
    }

    override fun onMenuItemClick(item: MenuItem?): Boolean {
        return true
    }
}