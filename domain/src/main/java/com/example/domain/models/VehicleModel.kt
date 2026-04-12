package com.example.domain.models

data class VehicleModel(
    val id: Id,
    val name: String,
    val model: String,
    val manufacturer: String,
    val cost: Int,
    val length: Float,
    val maxSpeed: Int,
    val crew: Int,
    val passengers: Int,
    val cargoCapacity: Int,
    val consumables: String,
    val vehicleClass: String,
    val pilots: List<Id>,
    val films: List<Id>
)
