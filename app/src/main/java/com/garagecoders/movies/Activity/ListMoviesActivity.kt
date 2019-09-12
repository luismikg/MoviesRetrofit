package com.garagecoders.movies.Activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import com.garagecoders.movies.Adapters.AdapterCategory
import com.garagecoders.movies.Adapters.AdapterMovies
import com.garagecoders.movies.R
import com.garagecoders.movies.models.Data
import com.garagecoders.movies.models.Movie

class ListMoviesActivity : AppCompatActivity() {

    private lateinit var listMovies:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list_movies)
        initUI()
    }

    private fun initUI(){
        this.listMovies = findViewById<ListView>(R.id.listMovies)
        val data:ArrayList<Movie> = getIntent().getSerializableExtra("movies") as ArrayList<Movie>
        val adapter = AdapterMovies( this, data)

        this.listMovies.adapter = adapter

    }
}
