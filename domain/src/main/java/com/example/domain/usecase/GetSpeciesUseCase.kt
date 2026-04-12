package com.example.domain.usecase

import com.example.domain.models.Id
import com.example.domain.models.SpeciesModel
import com.example.domain.repositories.SpeciesRepository

class GetSpeciesUseCase(val repository: SpeciesRepository) {

    suspend operator fun invoke(ids: List<Id> = emptyList()): List<SpeciesModel> {
        return if (ids.isEmpty()) {
            repository.getSpecies()
        } else {
            repository.getSpeciesById(ids)
        }
    }

}