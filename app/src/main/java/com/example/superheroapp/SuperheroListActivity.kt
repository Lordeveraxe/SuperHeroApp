package com.example.superheroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.data.generateSuperheroes
import com.example.superheroapp.ui.SuperheroAdapter

class SuperheroListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_list)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val superheroes = generateSuperheroes()
        val adapter = SuperheroAdapter(superheroes)
        recyclerView.adapter = adapter
    }
}