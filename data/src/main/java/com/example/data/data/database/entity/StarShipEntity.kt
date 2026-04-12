package com.example.data.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.models.Id

@Entity(tableName = "starship_table")
data class StarShipEntity(
    @PrimaryKey val id: Id,
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
