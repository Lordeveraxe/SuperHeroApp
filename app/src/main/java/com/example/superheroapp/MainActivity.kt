package com.example.superheroapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.ui.superhero.SuperheroAdapter
import com.example.superheroapp.ui.superhero.SuperheroViewModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private val viewModel: SuperheroViewModel by viewModels()

    @Inject
    lateinit var superheroAdapter: SuperheroAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        val superheroAdapter = SuperheroAdapter(
            onDetailsClick = { superhero ->
                val intent = Intent(this, SuperheroDetailsActivity::class.java)
                intent.putExtra("superhero", superhero)
                startActivity(intent)
            },
            onEnemiesClick = { enemies ->
                val intent = Intent(this, EnemyListActivity::class.java)
                intent.putExtra("enemies", ArrayList(enemies))
                startActivity(intent)
            }
        )

        recyclerView.adapter = superheroAdapter

        viewModel.superheroes.observe(this) { superheroes ->
            viewModel.enemies.observe(this) { enemies ->
                superheroAdapter.submitList(superheroes, enemies)
            }
        }

        viewModel.loadSuperheroes()
        viewModel.loadEnemies()
    }
}