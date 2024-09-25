package com.example.superheroapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.ui.SuperheroAdapter
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

        // Configurar RecyclerView
        val recyclerView = findViewById<RecyclerView>(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)

        // Configurar el adaptador con el manejo de clics en "Detalles"
        superheroAdapter = SuperheroAdapter { superhero ->
            val intent = Intent(this, SuperheroDetailsActivity::class.java)
            intent.putExtra("superhero", superhero)
            startActivity(intent)
        }

        recyclerView.adapter = superheroAdapter

        // Observar los datos desde el ViewModel
        viewModel.superheroes.observe(this) { superheroes ->
            superheroAdapter.submitList(superheroes)
        }

        // Cargar los superhéroes
        viewModel.loadSuperheroes()
    }
}