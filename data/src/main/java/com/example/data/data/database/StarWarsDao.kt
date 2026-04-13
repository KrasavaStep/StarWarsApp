package com.example.data.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.Companion.REPLACE
import androidx.room.Query
import com.example.data.data.database.entity.CharacterEntity
import com.example.data.data.database.entity.FilmEntity
import com.example.data.data.database.entity.PlanetEntity
import com.example.data.data.database.entity.SpeciesEntity
import com.example.data.data.database.entity.StarShipEntity
import com.example.data.data.database.entity.VehicleEntity
import com.example.domain.models.Id

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

    @Query("SELECT * FROM character_table")
    suspend fun getCharacters(): List<CharacterEntity>

    @Query("SELECT * FROM character_table WHERE id IN (:ids)")
    suspend fun getCharactersById(ids: List<Id>): List<CharacterEntity>

    @Query("SELECT * FROM film_table")
    suspend fun getFilms(): List<FilmEntity>

    @Query("SELECT * FROM film_table WHERE id IN (:ids)")
    suspend fun getFilmsById(ids: List<Id>): List<FilmEntity>

    @Query("SELECT * FROM vehicle_table")
    suspend fun getVehicles(): List<VehicleEntity>

    @Query("SELECT * FROM vehicle_table WHERE id IN (:ids)")
    suspend fun getVehiclesById(ids: List<Id>): List<VehicleEntity>

    @Query("SELECT * FROM starship_table")
    suspend fun getStarships(): List<StarShipEntity>

    @Query("SELECT * FROM starship_table WHERE id IN (:ids)")
    suspend fun getStarshipsById(ids: List<Id>): List<StarShipEntity>

    @Query("SELECT * FROM species_table")
    suspend fun getSpecies(): List<SpeciesEntity>

    @Query("SELECT * FROM species_table WHERE id IN (:ids)")
    suspend fun getSpeciesById(ids: List<Id>): List<SpeciesEntity>

    @Query("SELECT * FROM planet_table")
    suspend fun getPlanets(): List<PlanetEntity>

    @Query("SELECT * FROM planet_table WHERE id IN (:ids)")
    suspend fun getPlanetsById(ids: List<Id>): List<PlanetEntity>

}