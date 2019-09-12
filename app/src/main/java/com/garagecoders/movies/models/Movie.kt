package com.garagecoders.movies.models

import java.io.Serializable

data class Movie (val id:Int,
                   val title:String,
                   val subtitle:String,
                   val year:Int,
                   val description:String,
                   val status:Int,
                   val idCategory:Int) : Serializable