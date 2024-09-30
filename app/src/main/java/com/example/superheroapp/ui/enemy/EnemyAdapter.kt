package com.example.superheroapp.ui.enemy

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Enemy

class EnemyAdapter(private val enemies: ArrayList<Enemy>) :
    RecyclerView.Adapter<EnemyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EnemyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.enemy_item, parent, false)
        return EnemyViewHolder(view)
    }

    override fun onBindViewHolder(holder: EnemyViewHolder, position: Int) {
        val enemy = enemies[position]
        holder.enemyName.text = enemy.name
        holder.enemyPhoto.setImageResource(enemy.photo)
    }

    override fun getItemCount() = enemies.size
}