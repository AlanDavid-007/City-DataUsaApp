package com.example.datausaapp.data.model

import com.google.gson.annotations.SerializedName


data class State(

    @SerializedName("ID State")
    val stateId: String,
    @SerializedName("Population")
    var population: Int,
    @SerializedName("Slug State")
    var slugState: String,
    @SerializedName("State")
    var state: String,
    @SerializedName("Year")
    var year: Int
)