package com.example.domain.models

data class SpeciesModel(
    val id: Id,
    val name: String,
    val classification: String,
    val designation: String,
    val averageHeight: Int,
    val skinColors: String,
    val hairColors: String,
    val eyeColors: String,
    val avgLifespan: Int,
    val homeworld: Id,
    val language: String,
    val people: List<Id>,
    val films: List<Id>
)