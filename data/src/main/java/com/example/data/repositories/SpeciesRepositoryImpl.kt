package com.example.data.repositories

import com.example.domain.models.Id
import com.example.domain.models.SpeciesModel
import com.example.domain.repositories.SpeciesRepository

class SpeciesRepositoryImpl: SpeciesRepository {
    override suspend fun getSpecies(): List<SpeciesModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getSpeciesById(ids: List<Id>): List<SpeciesModel> {
        TODO("Not yet implemented")
    }
}