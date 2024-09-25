package com.example.superheroapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.superheroapp.R
import com.example.superheroapp.data.models.Enemy
import com.example.superheroapp.ui.enemy.EnemyAdapter

class EnemyListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enemy_list)

        val enemies = intent.getSerializableExtra("enemies") as ArrayList<Enemy>

        val recyclerView: RecyclerView = findViewById(R.id.enemy_recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = EnemyAdapter(enemies)
    }
}
