package com.garagecoders.movies.Api

import com.garagecoders.movies.models.CategoriesResponse
import retrofit2.Call
import retrofit2.http.GET

interface Api {

    @GET("categories")
    fun getCategories():Call<CategoriesResponse>
}