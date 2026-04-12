package com.example.data.repositories

import com.example.domain.models.Id
import com.example.domain.models.StarShipModel
import com.example.domain.repositories.StarshipRepository

class StarshipRepositoryImpl: StarshipRepository {
    override suspend fun getStarships(): List<StarShipModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getStarshipById(ids: List<Id>): List<StarShipModel> {
        TODO("Not yet implemented")
    }
}