package com.example.superheroapp.ui.superhero

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superheroapp.data.generateLocations
import com.example.superheroapp.data.generateSuperheroes
import com.example.superheroapp.data.models.Superhero

class SuperheroViewModel : ViewModel() {

    private val _superheroes = MutableLiveData<List<Superhero>>()
    val superheroes: LiveData<List<Superhero>> = _superheroes

    // Estado del superhéroe
    private val _superheroState = MutableLiveData<SuperheroState>()
    val superheroState: LiveData<SuperheroState> = _superheroState

    private val allSuperheroes = generateSuperheroes()
    private val allLocations = generateLocations()

    // Clase que representa el estado de la UI
    data class SuperheroState(
        val superhero: Superhero? = null,
        val friends: List<String> = emptyList(),
        val locations: List<String> = emptyList(),
        val powers: List<String> = emptyList(),
        val mainEnemy: String = ""
    )

    fun loadSuperheroes() {
        _superheroes.value = generateSuperheroes()
    }

    // Función para cargar los datos de un superhéroe específico
    fun loadSuperhero(superhero: Superhero) {
        val friends = superhero.friends.map { getSuperheroNameById(it) }
        val locations = superhero.locations.map { getLocationNameById(it) }
        val powers = superhero.powers.map { getPowerNameById(it) }

        _superheroState.value = SuperheroState(
            superhero = superhero,
            friends = friends,
            locations = locations,
            powers = powers,
            mainEnemy = superhero.mainEnemy.name
        )
    }

    // Función para obtener el nombre del superhéroe por su ID
    private fun getSuperheroNameById(id: Int): String {
        return allSuperheroes.find { it.id == id }?.name ?: "Unknown Superhero"
    }

    // Función para obtener el nombre de la ubicación por su ID
    private fun getLocationNameById(id: Int): String {
        return allLocations.find { it.id == id }?.name ?: "Unknown Location"
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
}