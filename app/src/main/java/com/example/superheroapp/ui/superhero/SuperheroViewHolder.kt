package com.example.superheroapp.ui.superhero

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R

class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
    val superheroImage: ImageView = view.findViewById(R.id.superhero_image)
    val superheroName: TextView = view.findViewById(R.id.superhero_name)
    val alterEgoName: TextView = view.findViewById(R.id.alter_ego_name)
    val btnDetails: Button = view.findViewById(R.id.btn_details)
    val btnEnemies: Button = view.findViewById(R.id.btn_enemies)
}
