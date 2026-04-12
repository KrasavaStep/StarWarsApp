package com.example.domain.models

data class StarShipModel(
    val id: Id,
    val name: String,
    val model: String,
    val manufacturer: String,
    val cost: String,
    val length: String,
    val maxSpeed: String,
    val crew: String,
    val passengers: String,
    val cargoCapacity: String,
    val consumables: String,
    val hyperdriveRating: String,
    val mglt: String,
    val starshipClass: String,
    val pilots: List<Id>,
    val films: List<Id>
)
