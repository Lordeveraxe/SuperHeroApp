package com.example.superheroapp

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.example.superheroapp.data.models.Superhero
import com.example.superheroapp.ui.superhero.SuperheroViewModel

class SuperheroDetailsActivity : AppCompatActivity() {

    private val viewModel: SuperheroViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_superhero_details)

        val imageView = findViewById<ImageView>(R.id.superhero_detail_image)
        val nameTextView = findViewById<TextView>(R.id.superhero_detail_name)
        val alterEgoTextView = findViewById<TextView>(R.id.superhero_detail_alter_ego)
        val powersTextView = findViewById<TextView>(R.id.superhero_detail_powers)
        val mainEnemyTextView = findViewById<TextView>(R.id.superhero_detail_main_enemy)
        val friendsTextView = findViewById<TextView>(R.id.superhero_detail_friends)
        val locationsTextView = findViewById<TextView>(R.id.superhero_detail_locations)

        val superhero = intent.getParcelableExtra<Superhero>("superhero")

        viewModel.superheroState.observe(this) { state ->
            state.superhero?.let { it ->
                imageView.setImageResource(it.photo)
                nameTextView.text = it.name
                alterEgoTextView.text = it.alterName
                powersTextView.text = state.powers.joinToString("\n") { "- $it" }
                mainEnemyTextView.text = state.mainEnemy
                friendsTextView.text = state.friends.joinToString("\n") { "- $it" }
                locationsTextView.text = state.locations.joinToString("\n") { "- $it" }
            }
        }

        superhero?.let { viewModel.loadSuperhero(it) }
    }
}