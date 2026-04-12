package com.example.data.data.network.mappers

import android.util.Log
import com.example.data.data.network.dto.CharacterDTO
import com.example.data.data.network.dto.FilmDTO
import com.example.data.data.network.dto.PlanetDTO
import com.example.data.data.network.dto.SpeciesDTO
import com.example.data.data.network.dto.StarshipDTO
import com.example.data.data.network.dto.VehicleDTO
import com.example.domain.models.CharacterModel
import com.example.domain.models.FilmModel
import com.example.domain.models.Id
import com.example.domain.models.PlanetModel
import com.example.domain.models.SpeciesModel
import com.example.domain.models.StarShipModel
import com.example.domain.models.VehicleModel
import kotlin.collections.map

fun CharacterDTO.mapToCharacters() = CharacterModel(
    id = convertToID(this.url),
    name = this.name,
    height = this.height,
    mass = this.mass,
    hairColor = this.hairColor,
    skinColor = this.skinColor,
    eyeColor = this.eyeColor,
    birthYear = this.birthYear,
    gender = this.gender,
    homeWorld = convertToID(this.homeworld),
    films = this.films.map { convertToID(it) },
    species = this.species.map { convertToID(it) },
    vehicles = this.vehicles.map { convertToID(it) },
    starships = this.starships.map { convertToID(it) }
)

fun FilmDTO.mapToFilm() = FilmModel(
    id = convertToID(this.url),
    title = this.title,
    episodeId = this.episodeId,
    openingCrawl = this.openingCrawl,
    director = this.director,
    producer = this.producer,
    releaseDate = this.releaseDate,
    characters = this.characters.map { convertToID(it) },
    planets = this.planets.map { convertToID(it) },
    starships = this.starships.map { convertToID(it) },
    vehicles = this.vehicles.map { convertToID(it) },
    species = this.species.map { convertToID(it) }
)

fun PlanetDTO.mapToPlanet() = PlanetModel(
    id = convertToID(this.url),
    name = this.name,
    rotationPeriod = this.rotationPeriod,
    orbitalPeriod = this.orbitalPeriod,
    diameter = this.diameter,
    climate = this.climate,
    gravity = this.gravity,
    terrain = this.terrain,
    surfaceWater = this.surfaceWater,
    population = this.population,
    residents = this.residents.map { convertToID(it) },
    films = this.films.map { convertToID(it) }
)

fun SpeciesDTO.mapToSpecies() = SpeciesModel(
    id = convertToID(this.url),
    name = this.name,
    classification = this.classification,
    designation = this.designation,
    averageHeight = this.averageHeight,
    skinColors = this.skinColors,
    hairColors = this.hairColors,
    eyeColors = this.eyeColors,
    avgLifespan = this.averageLifespan,
    homeworld = this.homeworld?.let { convertToID(it) },
    language = this.language,
    people = this.people.map { convertToID(it) },
    films = this.films.map { convertToID(it) }
)

fun StarshipDTO.mapToStarship() = StarShipModel(
    id = convertToID(this.url),
    name = this.name,
    model = this.model,
    manufacturer = this.manufacturer,
    cost = this.cost,
    length = this.length,
    maxSpeed = this.maxSpeed,
    crew = this.crew,
    passengers = this.passengers,
    cargoCapacity = this.cargoCapacity,
    consumables = this.consumables,
    hyperdriveRating = this.hyperdriveRating,
    mglt = this.mglt,
    starshipClass = this.starshipClass,
    pilots = this.pilots.map { convertToID(it) },
    films = this.films.map { convertToID(it) }
)

fun VehicleDTO.mapToVehicle() = VehicleModel(
    id = convertToID(this.url),
    name = this.name,
    model = this.model,
    manufacturer = this.manufacturer,
    cost = this.cost,
    length = this.length,
    maxSpeed = this.maxSpeed,
    crew = this.crew,
    passengers = this.passengers,
    cargoCapacity = this.cargoCapacity,
    consumables = this.consumables,
    vehicleClass = this.vehicleClass,
    pilots = this.pilots.map { convertToID(it) },
    films = this.films.map { convertToID(it) }
)

private fun convertToID(url: String): Id {
    val id = url.trim('/').substringAfterLast('/').toInt()
    return Id(id)
}