package com.example.data.repositories

import com.example.data.data.database.StarWarsDao
import com.example.data.data.database.mappers.mapToCharacter
import com.example.data.data.database.mappers.mapToSpecies
import com.example.domain.models.Id
import com.example.domain.models.SpeciesModel
import com.example.domain.repositories.SpeciesRepository

class SpeciesRepositoryImpl(
    private val dao: StarWarsDao
): SpeciesRepository {
    override suspend fun getSpecies(): List<SpeciesModel> {
        return dao.getSpecies().map { it.mapToSpecies() }
    }

    override suspend fun getSpeciesById(ids: List<Id>): List<SpeciesModel> {
        return dao.getSpeciesById(ids).map { it.mapToSpecies() }
    }
}