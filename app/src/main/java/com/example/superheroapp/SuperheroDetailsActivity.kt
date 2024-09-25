package com.example.superheroapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.superheroapp.data.generateSuperheroes
import com.example.superheroapp.data.generateLocations
import com.example.superheroapp.data.models.Superhero

class SuperheroDetailsActivity : AppCompatActivity() {

    private val allSuperheroes = generateSuperheroes() // Lista completa de superhéroes
    private val allLocations = generateLocations() // Lista completa de ubicaciones

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_details)

        // Recibir el superhéroe del intent
        val superhero = intent.getParcelableExtra<Superhero>("superhero")

        // Referencias a las vistas
        val imageView = findViewById<ImageView>(R.id.superhero_detail_image)
        val nameTextView = findViewById<TextView>(R.id.superhero_detail_name)
        val alterEgoTextView = findViewById<TextView>(R.id.superhero_detail_alter_ego)
        val powersTextView = findViewById<TextView>(R.id.superhero_detail_powers)
        val mainEnemyTextView = findViewById<TextView>(R.id.superhero_detail_main_enemy)
        val friendsTextView = findViewById<TextView>(R.id.superhero_detail_friends)
        val locationsTextView = findViewById<TextView>(R.id.superhero_detail_locations)

        // Cargar los detalles del superhéroe
        superhero?.let {
            imageView.setImageResource(it.photo)
            nameTextView.text = it.name
            alterEgoTextView.text = it.alterName

            // Mostrar los poderes como una lista
            powersTextView.text = it.powers.joinToString("\n") { powerId ->
                "- " + getPowerNameById(powerId)
            }

            // Mostrar el enemigo principal
            mainEnemyTextView.text = it.mainEnemy.name

            // Mostrar amigos como una lista (encontrar sus nombres)
            friendsTextView.text = it.friends.joinToString("\n") { friendId ->
                "- " + getSuperheroNameById(friendId)
            }

            // Mostrar ubicaciones como una lista (encontrar sus nombres)
            locationsTextView.text = it.locations.joinToString("\n") { locationId ->
                "- " + getLocationNameById(locationId)
            }
        }
    }

    // Función para obtener el nombre del poder por su ID
    private fun getPowerNameById(id: Int): String {
        return when (id) {
            1 -> "Flight"
            2 -> "Super Strength"
            3 -> "Invisibility"
            4 -> "Telepathy"
            5 -> "Speed"
            6 -> "Water Manipulation"
            7 -> "Super Intelligence"
            else -> "Unknown Power"
        }
    }

    // Función para obtener el nombre del superhéroe por su ID
    private fun getSuperheroNameById(id: Int): String {
        val superhero = allSuperheroes.find { it.id == id }
        return superhero?.name ?: "Unknown Superhero"
    }

    // Función para obtener el nombre de la ubicación por su ID
    private fun getLocationNameById(id: Int): String {
        val location = allLocations.find { it.id == id }
        return location?.name ?: "Unknown Location"
    }
}