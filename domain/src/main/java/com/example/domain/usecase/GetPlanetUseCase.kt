package com.example.domain.usecase

import com.example.domain.models.Id
import com.example.domain.models.PlanetModel
import com.example.domain.repositories.PlanetRepository

class GetPlanetUseCase(val repository: PlanetRepository) {

    suspend operator fun invoke(ids: List<Id> = emptyList()): List<PlanetModel> {
        return if (ids.isEmpty()) {
            repository.getPlanets()
        } else {
            repository.getPlanetById(ids)
        }
    }

}