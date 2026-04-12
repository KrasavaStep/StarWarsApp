package com.example.data.repositories

import com.example.domain.models.FilmModel
import com.example.domain.models.Id
import com.example.domain.repositories.FilmRepository

class FilmRepositoryImpl: FilmRepository {
    override suspend fun getFilms(): List<FilmModel> {
        TODO("Not yet implemented")
    }

    override suspend fun getFilmsById(ids: List<Id>): List<FilmModel> {
        TODO("Not yet implemented")
    }
}