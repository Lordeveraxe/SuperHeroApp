package com.example.superheroapp.data.models

import android.os.Parcelable
import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize

@Parcelize
data class Superhero(
    val id: Int,
    val name: String,
    val alterName: String,
    @DrawableRes val photo: Int,
    // Lista de IDs de poderes
    val powers: List<Int>,
    // Lista de IDs de amigos (otros superhéroes)
    val friends: List<Int>,
    val mainEnemy: Enemy,
    // Lista de IDs de enemigos
    val enemies: List<Int>,
    // Lista de IDs de ubicaciones
    val locations: List<Int>
) : Parcelable