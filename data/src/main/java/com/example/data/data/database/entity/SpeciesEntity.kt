package com.example.data.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.models.Id

@Entity(tableName = "species_table")
data class SpeciesEntity(
    @PrimaryKey val id: Id,
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