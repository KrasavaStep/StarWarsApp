package com.example.domain.repositories

import com.example.domain.utils.NetworkResponse

interface NetworkRepository {

    suspend fun fetchDataFromNetwork(): NetworkResponse<Boolean>

}