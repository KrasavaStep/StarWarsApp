package com.example.data.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.domain.models.Id

@Entity(tableName = "character_table")
data class CharacterEntity(
    @PrimaryKey val id: Id,
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val skinColor: String,
    val eyeColor: String,
    val birthYear: String,
    val gender: String,
    val homeWorld: Id,
    val films: List<Id>,
    val species: List<Id>,
    val vehicles: List<Id>,
    val starships: List<Id>
)
