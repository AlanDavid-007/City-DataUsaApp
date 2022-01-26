package com.example.datausaapp.data.api

import com.example.datausaapp.data.model.DateStates
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiData {
    @GET("data")
    suspend fun getStates(
        @Query("drilldowns") drillDomns: String = "State",
        @Query("measures") measures: String = "Population",
        @Query("year") year: String = "latest"
    ): DateStates
}