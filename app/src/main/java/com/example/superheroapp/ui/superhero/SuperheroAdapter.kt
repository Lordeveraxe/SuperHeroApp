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
    private val onDetailsClick: (Superhero) -> Unit,
    private val onEnemiesClick: (List<Enemy>) -> Unit,
) : ListAdapter<Superhero, SuperheroViewHolder>(SuperheroDiffCallback()) {

    private var enemyList: List<Enemy> = emptyList()

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

        holder.btnEnemies.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, EnemyListActivity::class.java)

            val selectedEnemies = superhero.enemies.mapNotNull { enemyId ->
                enemyList.find { it.id == enemyId }
            }

            intent.putExtra("enemies", ArrayList(selectedEnemies))
            context.startActivity(intent)
        }
    }

    fun submitList(superheroes: List<Superhero>, enemies: List<Enemy>) {
        this.enemyList = enemies
        super.submitList(superheroes)
    }
}