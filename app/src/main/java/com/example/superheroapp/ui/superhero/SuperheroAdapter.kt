package com.example.superheroapp.ui.superhero

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.EnemyListActivity
import com.example.superheroapp.data.models.Enemy
import javax.inject.Inject

class SuperheroAdapter @Inject constructor(
    private val onDetailsClick: (Superhero) -> Unit
) : ListAdapter<Superhero, SuperheroViewHolder>(SuperheroDiffCallback()) {

    private var enemyList: List<Enemy> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SuperheroViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_superhero, parent, false)
        return SuperheroViewHolder(view)
    }

    fun submitList(superheroes: List<Superhero>, enemies: List<Enemy>) {
        this.enemyList = enemies
        super.submitList(superheroes)
    }

    override fun onBindViewHolder(holder: SuperheroViewHolder, position: Int) {
        val superhero = getItem(position)
        holder.superheroName.text = superhero.name
        holder.alterEgoName.text = superhero.alterName
        holder.superheroImage.setImageResource(superhero.photo)

        holder.btnDetails.setOnClickListener {
            onDetailsClick(superhero)
        }
        holder.btnEnemies.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, EnemyListActivity::class.java)

            // Obtener la lista de enemigos asociada al superhéroe por ID
            val selectedEnemies = superhero.enemies.map { enemyId ->
                enemyList.find { it.id == enemyId }
            }.filterNotNull()  // Filtrar enemigos nulos

            // Pasar la lista de enemigos a la actividad
            intent.putExtra("enemies", ArrayList(selectedEnemies))  // Convertir a ArrayList
            context.startActivity(intent)
        }

    }
}