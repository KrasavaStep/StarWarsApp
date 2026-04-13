package com.example.data.repositories

import com.example.data.data.database.StarWarsDao
import com.example.data.data.database.mappers.mapToCharacter
import com.example.data.data.database.mappers.mapToStarship
import com.example.domain.models.Id
import com.example.domain.models.StarShipModel
import com.example.domain.repositories.StarshipRepository

class StarshipRepositoryImpl(
    private val dao: StarWarsDao
): StarshipRepository {
    override suspend fun getStarships(): List<StarShipModel> {
        return dao.getStarships().map { it.mapToStarship() }
    }

    override suspend fun getStarshipById(ids: List<Id>): List<StarShipModel> {
        return dao.getStarshipsById(ids).map { it.mapToStarship() }
    }
}