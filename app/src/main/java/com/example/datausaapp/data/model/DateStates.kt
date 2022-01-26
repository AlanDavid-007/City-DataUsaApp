package com.example.datausaapp.data.model

import com.google.gson.annotations.SerializedName

data class DateStates(
    @SerializedName("data")
    val `data`: List<State>
)