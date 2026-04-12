package com.example.domain.repositories

import com.example.domain.models.CharacterModel
import com.example.domain.models.Id

interface CharacterRepository {

    suspend fun getCharacters(): List<CharacterModel>
    suspend fun getCharactersById(ids: List<Id>): List<CharacterModel>

}