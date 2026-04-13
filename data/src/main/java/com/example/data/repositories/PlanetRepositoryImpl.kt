package com.example.data.repositories

import com.example.data.data.database.StarWarsDao
import com.example.data.data.database.mappers.mapToPlanet
import com.example.domain.models.Id
import com.example.domain.models.PlanetModel
import com.example.domain.repositories.PlanetRepository

class PlanetRepositoryImpl(
    private val dao: StarWarsDao
): PlanetRepository {
    override suspend fun getPlanets(): List<PlanetModel> {
        return dao.getPlanets().map { it.mapToPlanet() }
    }

    override suspend fun getPlanetById(ids: List<Id>): List<PlanetModel> {
        return dao.getPlanetsById(ids).map { it.mapToPlanet() }
    }
}