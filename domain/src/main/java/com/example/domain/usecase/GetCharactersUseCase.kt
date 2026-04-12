package com.example.domain.usecase

import com.example.domain.models.CharacterModel
import com.example.domain.models.Id
import com.example.domain.repositories.CharacterRepository

class GetCharactersUseCase(val repository: CharacterRepository) {

    suspend operator fun invoke(ids: List<Id> = emptyList()): List<CharacterModel> {
        return if (ids.isEmpty()) {
            repository.getCharacters()
        } else {
            repository.getCharactersById(ids)
        }
    }

}