package com.example.domain.usecase

import com.example.domain.repositories.SharedPrefsRepository

class SaveToPrefsUseCase(private val repository: SharedPrefsRepository) {

    operator fun invoke(key: String, value: Boolean) {
        repository.addDataToPrefs(key, value)
    }

}