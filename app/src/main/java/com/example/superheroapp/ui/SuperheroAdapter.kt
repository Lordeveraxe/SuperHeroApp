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
import com.example.superheroapp.data.models.Enemy
import com.example.superheroapp.data.models.Superhero

class SuperheroAdapter :
    ListAdapter<Superhero, SuperheroAdapter.SuperheroViewHolder>(SuperheroDiffCallback()) {


    private var enemyList: List<Enemy> = emptyList()
    class SuperheroViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val superheroImage: ImageView = view.findViewById(R.id.superhero_image)
        val superheroName: TextView = view.findViewById(R.id.superhero_name)
        val alterEgoName: TextView = view.findViewById(R.id.alter_ego_name)
        val btnEnemies: Button = view.findViewById(R.id.btn_enemies)
        val btnDetails: Button = view.findViewById(R.id.btn_details)
    }

    fun submitList(superheroes: List<Superhero>, enemies: List<Enemy>) {
        this.enemyList = enemies  // Actualizar la lista de enemigos
        super.submitList(superheroes)  // Llamar al método original para actualizar la lista de superhéroes
    }

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

        holder.btnEnemies.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, EnemyListActivity::class.java)

            val selectedEnemies = superhero.enemies.map { enemyId ->
                enemyList.find { it.id == enemyId }
            }.filterNotNull()

            intent.putExtra("enemies", ArrayList(selectedEnemies))
            context.startActivity(intent)
        }
    }
}