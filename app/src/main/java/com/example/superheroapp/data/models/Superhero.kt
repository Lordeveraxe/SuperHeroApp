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
    val powers: List<Int>,
    val friends: List<Int>,
    val mainEnemy: Enemy,
    val enemies: List<Int>,
    val locations: List<Int>
) : Parcelable