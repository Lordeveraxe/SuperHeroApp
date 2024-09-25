package com.example.superheroapp.data.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Enemy

class EnemyAdapter(private val enemies: List<Enemy>) :
    RecyclerView.Adapter<EnemyAdapter.EnemyViewHolder>() {

    class EnemyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val enemyPhoto: ImageView = itemView.findViewById(R.id.enemy_photo)
        val enemyName: TextView = itemView.findViewById(R.id.enemy_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnemyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.enemy_item, parent, false)
        return EnemyViewHolder(view)
    }

    override fun onBindViewHolder(holder: EnemyViewHolder, position: Int) {
        val enemy = enemies[position]
        holder.enemyName.text = enemy.name
        holder.enemyPhoto.setImageResource(enemy.photo)
    }

    override fun getItemCount() = enemies.size
}
