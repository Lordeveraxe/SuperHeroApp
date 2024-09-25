package com.example.superheroapp.di

import com.example.superheroapp.ui.SuperheroAdapter
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
        return SuperheroAdapter()
    }
}