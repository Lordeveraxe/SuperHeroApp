package com.example.superheroapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Superhero

class SuperheroAdapter(private val superheroes: List<Superhero>) :
    RecyclerView.Adapter<SuperheroAdapter.SuperheroViewHolder>() {

    class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val superheroImage: ImageView = view.findViewById(R.id.superhero_image)
        val superheroName: TextView = view.findViewById(R.id.superhero_name)
        val alterEgoName: TextView = view.findViewById(R.id.alter_ego_name)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_superhero, parent, false)
        return SuperheroViewHolder(view)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val superhero = superheroes[position]
        holder.superheroName.text = superhero.name
        holder.alterEgoName.text = superhero.alterName
        holder.superheroImage.setImageResource(superhero.photo)
    }

    override fun getItemCount(): Int {
        return superheroes.size
    }
}