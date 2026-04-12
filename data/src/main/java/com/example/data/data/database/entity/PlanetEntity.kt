package com.example.data.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.models.Id

@Entity(tableName = "planet_table")
data class PlanetEntity(
    @PrimaryKey val id: Id,
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
