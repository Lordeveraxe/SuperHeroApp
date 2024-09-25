package com.example.superheroapp.ui.superhero

import androidx.recyclerview.widget.DiffUtil
import com.example.superheroapp.data.models.Superhero

class SuperheroDiffCallback : DiffUtil.ItemCallback<Superhero>() {
    override fun areItemsTheSame(oldItem: Superhero, newItem: Superhero): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Superhero, newItem: Superhero): Boolean {
        return oldItem == newItem
    }
}