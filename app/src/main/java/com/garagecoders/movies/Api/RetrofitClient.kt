package com.garagecoders.movies.Api

import com.google.gson.Gson
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

//Singleton Retrofit
object RetrofitClient {

    private const val BASE_URL = "http://garagecoders.rocks:4000/api/movies/"

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor{ chain ->
            val origin = chain.request()
            val requestBuilder = origin.newBuilder()
                .method( origin.method(), origin.body() )

            val request = requestBuilder.build()
            chain.proceed(request)
        }.build()

    val instance: Api by lazy {
        val retrofit = Retrofit.Builder()
            .baseUrl( this.BASE_URL )
            .addConverterFactory( GsonConverterFactory.create() )
            .build()

        retrofit.create(Api::class.java)
    }
}