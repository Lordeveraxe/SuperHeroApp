package com.example.superheroapp.data.models

import androidx.annotation.DrawableRes
import kotlinx.parcelize.Parcelize
import android.os.Parcelable

@Parcelize
data class Enemy(
    val id: Int,
    val name: String,
    @DrawableRes val photo: Int
) : Parcelable
