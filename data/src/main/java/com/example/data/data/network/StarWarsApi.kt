package com.example.data.data.network

import com.example.data.data.network.dto.CharacterDTO
import com.example.data.data.network.dto.FilmDTO
import com.example.data.data.network.dto.PagedResponse
import com.example.data.data.network.dto.PlanetDTO
import com.example.data.data.network.dto.SpeciesDTO
import com.example.data.data.network.dto.StarshipDTO
import com.example.data.data.network.dto.VehicleDTO
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Url

interface StarWarsApi {

    @GET("people/")
    suspend fun getAllCharacters(): Response<PagedResponse<CharacterDTO>>

    @GET
    suspend fun getCharactersByUrl(@Url url: String): Response<PagedResponse<CharacterDTO>>

    @GET("films/")
    suspend fun getAllFilms(): Response<PagedResponse<FilmDTO>>

    @GET
    suspend fun getFilmsByUrl(@Url url: String): Response<PagedResponse<FilmDTO>>

    @GET("species/")
    suspend fun getAllSpecies(): Response<PagedResponse<SpeciesDTO>>

    @GET
    suspend fun getSpeciesByUrl(@Url url: String): Response<PagedResponse<SpeciesDTO>>

    @GET("starships/")
    suspend fun getAllStarships(): Response<PagedResponse<StarshipDTO>>

    @GET
    suspend fun getStarshipsByUrl(@Url url: String): Response<PagedResponse<StarshipDTO>>

    @GET("vehicles/")
    suspend fun getAllVehicles(): Response<PagedResponse<VehicleDTO>>

    @GET
    suspend fun getVehiclesByUrl(@Url url: String): Response<PagedResponse<VehicleDTO>>

    @GET("planets/")
    suspend fun getAllPlanets(): Response<PagedResponse<PlanetDTO>>

    @GET
    suspend fun getPlanetsByUrl(@Url url: String): Response<PagedResponse<PlanetDTO>>

    companion object {
        const val STAR_WARS_API_URL = "https://swapi.dev/api/"
    }
}