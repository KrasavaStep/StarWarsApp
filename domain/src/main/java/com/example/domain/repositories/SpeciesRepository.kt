package com.example.domain.repositories

import com.example.domain.models.Id
import com.example.domain.models.SpeciesModel

interface SpeciesRepository {

    suspend fun getSpecies(): List<SpeciesModel>
    suspend fun getSpeciesById(ids: List<Id>): List<SpeciesModel>

}