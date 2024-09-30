package com.example.superheroapp.di

import android.content.Intent
import androidx.core.content.ContextCompat.startActivity
import com.example.superheroapp.EnemyListActivity
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.ui.superhero.SuperheroAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SuperheroModule {

    @Singleton
    @Provides
    fun provideSuperheroAdapter(): SuperheroAdapter {
        return SuperheroAdapter({ superhero: Superhero ->
            println("Clicked on: ${superhero.name}")
        }, {
            println("Enemies clicked")
        })
    }
}