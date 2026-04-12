package com.example.domain.repositories

import com.example.domain.models.Id
import com.example.domain.models.PlanetModel

interface PlanetRepository {

    suspend fun getPlanets(): List<PlanetModel>
    suspend fun getPlanetById(ids: List<Id>): List<PlanetModel>

}