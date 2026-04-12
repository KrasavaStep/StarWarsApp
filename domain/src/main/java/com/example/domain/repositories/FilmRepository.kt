package com.example.domain.repositories

import com.example.domain.models.FilmModel
import com.example.domain.models.Id

interface FilmRepository {

    suspend fun getFilms(): List<FilmModel>
    suspend fun getFilmsById(ids: List<Id>): List<FilmModel>

}