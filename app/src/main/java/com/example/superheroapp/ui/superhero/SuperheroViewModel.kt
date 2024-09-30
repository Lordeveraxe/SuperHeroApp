package com.example.superheroapp.ui.superhero

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.superheroapp.data.generateEnemies
import com.example.superheroapp.data.generateLocations
import com.example.superheroapp.data.generateSuperheroes
import com.example.superheroapp.data.models.Enemy
import com.example.superheroapp.data.models.Superhero

class SuperheroViewModel : ViewModel() {

    private val _superheroes = MutableLiveData<List<Superhero>>()
    val superheroes: LiveData<List<Superhero>> = _superheroes

    private val _enemies = MutableLiveData<List<Enemy>>()
    val enemies: LiveData<List<Enemy>> = _enemies

    private val _superheroState = MutableLiveData<SuperheroState>()
    val superheroState: LiveData<SuperheroState> = _superheroState

    private val allSuperheroes = generateSuperheroes()
    private val allEnemies = generateEnemies()
    private val allLocations = generateLocations()

    data class SuperheroState(
        val superhero: Superhero? = null,
        val friends: List<String> = emptyList(),
        val locations: List<String> = emptyList(),
        val powers: List<String> = emptyList(),
        val mainEnemy: String = ""
    )

    fun loadSuperheroes() {
        _superheroes.value = allSuperheroes
    }

    fun loadEnemies() {
        _enemies.value = allEnemies
    }

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

    private fun getSuperheroNameById(id: Int): String {
        return allSuperheroes.find { it.id == id }?.name ?: "Unknown Superhero"
    }

    private fun getLocationNameById(id: Int): String {
        return allLocations.find { it.id == id }?.name ?: "Unknown Location"
    }

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