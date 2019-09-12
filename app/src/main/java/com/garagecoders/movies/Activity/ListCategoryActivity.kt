package com.garagecoders.movies.Activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ListView
import android.widget.Toast
import com.garagecoders.movies.Adapters.AdapterCategory
import com.garagecoders.movies.Api.RetrofitClient
import com.garagecoders.movies.R
import com.garagecoders.movies.models.CategoriesResponse
import com.garagecoders.movies.models.Data
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListCategoryActivity : AppCompatActivity() {

    lateinit var responsee: Response<CategoriesResponse>
    private lateinit var listCategory:ListView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initData()
    }

    private fun initUI(){
        this.listCategory = findViewById<ListView>(R.id.listCategory)
        val data:ArrayList<Data> = responsee.body()?.data!!
        val adapter = AdapterCategory( this, data)

        this.listCategory.adapter = adapter

        initActios()
    }


    private fun initActios(){
        this.listCategory.onItemClickListener = AdapterView.OnItemClickListener { parent, view, position, id ->
            // This is your listview's selected item
            val data = parent.getItemAtPosition(position) as Data

            val intent = Intent(this, ListMoviesActivity::class.java)
            intent.putExtra("movies", data.movies)
            startActivity(intent);
        }
    }

    private fun initData(){
        RetrofitClient.instance.getCategories().enqueue(object: Callback<CategoriesResponse>{
            override fun onFailure(call: Call<CategoriesResponse>, t: Throwable) {
                Toast.makeText(applicationContext, t.message, Toast.LENGTH_LONG).show()
            }

            override fun onResponse( call: Call<CategoriesResponse>, response: Response<CategoriesResponse>
            ) {
                if( response.code() == 200 ) {
                    responsee = response
                    initUI()
                }else{
                    Toast.makeText(applicationContext, response.message(), Toast.LENGTH_LONG)
                }
            }
        })
    }
}
