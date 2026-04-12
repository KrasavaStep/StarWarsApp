package com.example.domain.models

data class PlanetModel(
    val id: Id,
    val name: String,
    val rotationPeriod: Int,
    val orbitalPeriod: Int,
    val diameter: Int,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: Int,
    val population: Int,
    val residents: List<Id>,
    val films: List<Id>
)
