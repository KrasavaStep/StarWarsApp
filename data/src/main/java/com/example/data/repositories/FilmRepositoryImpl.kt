package com.example.data.repositories

import com.example.data.data.database.StarWarsDao
import com.example.data.data.database.mappers.mapToFilm
import com.example.domain.models.FilmModel
import com.example.domain.models.Id
import com.example.domain.repositories.FilmRepository

class FilmRepositoryImpl(
    private val dao: StarWarsDao
): FilmRepository {
    override suspend fun getFilms(): List<FilmModel> {
        return dao.getFilms().map { it.mapToFilm() }
    }

    override suspend fun getFilmsById(ids: List<Id>): List<FilmModel> {
        return dao.getFilmsById(ids).map { it.mapToFilm() }
    }
}