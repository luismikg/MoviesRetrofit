package com.garagecoders.movies.models

import com.google.gson.annotations.SerializedName


data class CategoriesResponse (@SerializedName("ok") val status: Boolean,
                               val data: ArrayList<Data>)