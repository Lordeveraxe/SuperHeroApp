package com.example.superheroapp.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.ListAdapter
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.ui.superhero.SuperheroDiffCallback
import com.example.superheroapp.ui.superhero.SuperheroViewHolder
import javax.inject.Inject

class SuperheroAdapter @Inject constructor(
    private val onDetailsClick: (Superhero) -> Unit
) : ListAdapter<Superhero, SuperheroViewHolder>(SuperheroDiffCallback()) {

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

        holder.btnDetails.setOnClickListener {
            onDetailsClick(superhero)
        }
    }
}