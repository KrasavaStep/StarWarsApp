package com.example.domain.usecase

import com.example.domain.models.FilmModel
import com.example.domain.models.Id
import com.example.domain.repositories.FilmRepository

class GetFilmsUseCase(val repository: FilmRepository) {

    suspend operator fun invoke(ids: List<Id> = emptyList()): List<FilmModel> {
        return if (ids.isEmpty()) {
            repository.getFilms()
        } else {
            repository.getFilmsById(ids)
        }
    }

}