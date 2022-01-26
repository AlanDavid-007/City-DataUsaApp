package com.example.datausaapp.data.repository

import com.example.datausaapp.data.api.ApiData
import com.example.datausaapp.data.model.State

class StateRepository(private val getInstance: ApiData?) {

    suspend fun getStates(): List<State> {
        val response = getInstance?.getStates()?.data ?: listOf()
        return response
    }
}