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
    val cost: Int,
    val length: Float,
    val maxSpeed: Int,
    val crew: Int,
    val passengers: Int,
    val cargoCapacity: Int,
    val consumables: String,
    val hyperdriveRating: Float,
    val mglt: Int,
    val starshipClass: String,
    val pilots: List<Id>,
    val films: List<Id>
)
