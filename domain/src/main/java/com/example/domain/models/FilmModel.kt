package com.example.domain.models

data class FilmModel(
    val id: Id,
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
