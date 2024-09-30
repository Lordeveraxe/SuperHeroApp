package com.example.superheroapp.ui.enemy

import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R

class EnemyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val enemyPhoto: ImageView = itemView.findViewById(R.id.enemy_photo)
    val enemyName: TextView = itemView.findViewById(R.id.enemy_name)
}