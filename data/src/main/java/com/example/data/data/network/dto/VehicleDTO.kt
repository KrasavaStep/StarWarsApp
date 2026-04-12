package com.example.data.data.network.dto

import com.google.gson.annotations.SerializedName

data class VehicleDTO(
    val name: String,
    val model: String,
    val manufacturer: String,
    @SerializedName("cost_in_credits") val cost: String,
    val length: String,
    @SerializedName("max_atmosphering_speed") val maxSpeed: String,
    val crew: String,
    val passengers: String,
    @SerializedName("cargo_capacity") val cargoCapacity: String,
    val consumables: String,
    @SerializedName("vehicle_class") val vehicleClass: String,
    val pilots: List<String>,
    val films: List<String>,
    val created: String,
    val edited: String,
    val url: String
)
