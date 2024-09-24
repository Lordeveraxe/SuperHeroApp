package com.example.superheroapp

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val superheroButton = findViewById<Button>(R.id.btn_superheroes)

        superheroButton.setOnClickListener {
            // Iniciar la actividad que muestra el RecyclerView
            val intent = Intent(this, SuperheroListActivity::class.java)
            startActivity(intent)
        }
    }
}