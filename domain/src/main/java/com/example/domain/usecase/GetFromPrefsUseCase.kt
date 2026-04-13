package com.example.domain.usecase

import com.example.domain.repositories.SharedPrefsRepository

class GetFromPrefsUseCase(private val repository: SharedPrefsRepository) {

    operator fun invoke(key: String): Boolean {
        return repository.getDataFromPrefs(key)
    }
}