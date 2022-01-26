package com.example.datausaapp.data.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiClientInstance {

    private var retrofit: Retrofit? = null
    private const val BASE_URL = "https://datausa.io/api/"


    val retrofitInstance: ApiData?
        get() {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit?.create(ApiData::class.java)
        }
}