package com.example.data.repositories

import com.example.data.data.database.StarWarsDao
import com.example.data.data.database.mappers.mapToCharacter
import com.example.domain.models.CharacterModel
import com.example.domain.models.Id
import com.example.domain.repositories.CharacterRepository

class CharacterRepositoryImpl(
    private val dao: StarWarsDao
): CharacterRepository {

    override suspend fun getCharacters(): List<CharacterModel> {
        return dao.getCharacters().map { it.mapToCharacter() }
    }

    override suspend fun getCharactersById(ids: List<Id>): List<CharacterModel> {
        return dao.getCharactersById(ids).map { it.mapToCharacter() }
    }
}