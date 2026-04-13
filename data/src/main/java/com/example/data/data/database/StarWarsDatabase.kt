package com.example.data.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.data.data.database.entity.CharacterEntity
import com.example.data.data.database.entity.FilmEntity
import com.example.data.data.database.entity.PlanetEntity
import com.example.data.data.database.entity.SpeciesEntity
import com.example.data.data.database.entity.StarShipEntity
import com.example.data.data.database.entity.VehicleEntity
import com.example.data.data.database.mappers.Converters

@Database(
    entities = [
        CharacterEntity::class,
        FilmEntity::class,
        SpeciesEntity::class,
        StarShipEntity::class,
        VehicleEntity::class,
        PlanetEntity::class
    ],
    version = 1
)
@TypeConverters(Converters::class)
abstract class StarWarsDatabase() : RoomDatabase() {
    abstract fun getDao(): StarWarsDao
}
