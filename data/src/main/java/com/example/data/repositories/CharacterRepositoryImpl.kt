package com.example.data.repositories

import com.example.data.data.network.StarWarsApi
import com.example.domain.models.CharacterModel
import com.example.domain.models.Id
import com.example.domain.repositories.CharacterRepository

class CharacterRepositoryImpl(
): CharacterRepository {

    override suspend fun getCharacters(): List<CharacterModel> {
        TODO()
    }

    override suspend fun getCharactersById(ids: List<Id>): List<CharacterModel> {
        TODO("Not yet implemented")
    }
}