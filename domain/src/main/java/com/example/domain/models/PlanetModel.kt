package com.example.domain.models

data class PlanetModel(
    val id: Id,
    val name: String,
    val rotationPeriod: String,
    val orbitalPeriod: String,
    val diameter: String,
    val climate: String,
    val gravity: String,
    val terrain: String,
    val surfaceWater: String,
    val population: String,
    val residents: List<Id>,
    val films: List<Id>
)
