package com.example.domain.usecase

import com.example.domain.models.Id
import com.example.domain.models.StarShipModel
import com.example.domain.repositories.StarshipRepository

class GetStarshipUseCase(val repository: StarshipRepository) {
    suspend operator fun invoke(ids: List<Id> = emptyList()): List<StarShipModel> {
        return if (ids.isEmpty()) {
            repository.getStarships()
        } else {
            repository.getStarshipById(ids)
        }
    }
}