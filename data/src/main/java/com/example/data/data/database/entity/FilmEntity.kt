package com.example.data.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.models.Id

@Entity(tableName = "film_table")
data class FilmEntity(
    @PrimaryKey val id: Id,
    val title: String,
    val episodeId: Int,
    val openingCrawl: String,
    val director: String,
    val producer: String,
    val releaseDate: String,
    val characters: List<Id>,
    val planets: List<Id>,
    val starships: List<Id>,
    val vehicles: List<Id>,
    val species: List<Id>
)
