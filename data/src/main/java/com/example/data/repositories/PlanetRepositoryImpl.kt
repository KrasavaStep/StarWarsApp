package com.example.data.repositories

import com.example.domain.models.Id
import com.example.domain.models.PlanetModel
import com.example.domain.repositories.PlanetRepository

class PlanetRepositoryImpl: PlanetRepository {
    override suspend fun getPlanets(): List<PlanetModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getPlanetById(ids: List<Id>): List<PlanetModel> {
        TODO("Not yet implemented")
    }
}