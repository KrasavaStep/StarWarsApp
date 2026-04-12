package com.example.domain.repositories

import com.example.domain.models.Id
import com.example.domain.models.StarShipModel

interface StarshipRepository {

    suspend fun getStarships(): List<StarShipModel>
    suspend fun getStarshipById(ids: List<Id>): List<StarShipModel>

}