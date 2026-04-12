package com.example.data.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import com.example.data.data.database.entity.CharacterEntity
import com.example.data.data.database.entity.FilmEntity
import com.example.data.data.database.entity.PlanetEntity
import com.example.data.data.database.entity.SpeciesEntity
import com.example.data.data.database.entity.StarShipEntity
import com.example.data.data.database.entity.VehicleEntity

@Dao
interface StarWarsDao {

    @Insert(onConflict = REPLACE)
    suspend fun addCharactersData(items: List<CharacterEntity>)

    @Insert(onConflict = REPLACE)
    suspend fun addFilmData(items: List<FilmEntity>)

    @Insert(onConflict = REPLACE)
    suspend fun addSpeciesData(items: List<SpeciesEntity>)

    @Insert(onConflict = REPLACE)
    suspend fun addStarshipData(items: List<StarShipEntity>)

    @Insert(onConflict = REPLACE)
    suspend fun addVehicleData(items: List<VehicleEntity>)

    @Insert(onConflict = REPLACE)
    suspend fun addPlanetData(items: List<PlanetEntity>)

}