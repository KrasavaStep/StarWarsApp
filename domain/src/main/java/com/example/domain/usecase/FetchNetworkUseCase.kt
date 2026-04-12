package com.example.domain.usecase

import com.example.domain.repositories.NetworkRepository
import com.example.domain.utils.NetworkResponse

class FetchNetworkUseCase(private val repository: NetworkRepository) {

    suspend operator fun invoke(): NetworkResponse<Boolean> = repository.fetchDataFromNetwork()


}