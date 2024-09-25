package com.example.superheroapp.ui

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.SuperheroDetailsActivity
import com.example.superheroapp.data.models.Superhero

class SuperheroAdapter :
    ListAdapter<Superhero, SuperheroViewHolder>(SuperheroDiffCallback()) {
        
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_superhero, parent, false)
        return SuperheroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val superhero = getItem(position)
        holder.superheroName.text = superhero.name
        holder.alterEgoName.text = superhero.alterName
        holder.superheroImage.setImageResource(superhero.photo)

        // Botón de "Detalles"
        holder.btnDetails.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, SuperheroDetailsActivity::class.java)
            intent.putExtra("superhero", superhero)  // Pasa el objeto 'superhero' a la actividad
            context.startActivity(intent)
        }

        // Botón de "Enemigos" (sin funcionalidad por ahora)
        holder.btnEnemies.setOnClickListener {
            // Lógica futura para el botón de enemigos
        }
    }
}