package com.example.domain.models

data class CharacterModel(
    val id: Id,
    val name: String,
    val height: Int,
    val mass: Int,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val homeWorld: Id,
    val films: List<Id>,
    val species: List<Id>,
    val vehicles: List<Id>,
    val starships: List<Id>
)
