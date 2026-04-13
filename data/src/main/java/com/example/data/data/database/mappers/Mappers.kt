package com.example.data.data.database.mappers

import com.example.data.data.database.entity.CharacterEntity
import com.example.data.data.database.entity.FilmEntity
import com.example.data.data.database.entity.PlanetEntity
import com.example.data.data.database.entity.SpeciesEntity
import com.example.data.data.database.entity.StarShipEntity
import com.example.data.data.database.entity.VehicleEntity
import com.example.domain.models.CharacterModel
import com.example.domain.models.FilmModel
import com.example.domain.models.PlanetModel
import com.example.domain.models.SpeciesModel
import com.example.domain.models.StarShipModel
import com.example.domain.models.VehicleModel

fun CharacterModel.mapToCharacterEntity() = CharacterEntity(
    id = this.id,
    name = this.name,
    height = this.height,
    mass = this.mass,
    hairColor = this.hairColor,
    skinColor = this.skinColor,
    eyeColor = this.eyeColor,
    birthYear = this.birthYear,
    gender = this.gender,
    homeWorld = this.homeWorld,
    films = this.films,
    species = this.species,
    vehicles = this.vehicles,
    starships = this.starships
)

fun FilmModel.mapToFilmEntity() = FilmEntity(
    id = this.id,
    title = this.title,
    episodeId = this.episodeId,
    openingCrawl = this.openingCrawl,
    director = this.director,
    producer = this.producer,
    releaseDate = this.releaseDate,
    characters = this.characters,
    planets = this.planets,
    starships = this.starships,
    vehicles = this.vehicles,
    species = this.species
)

fun PlanetModel.mapToPlanetEntity() = PlanetEntity(
    id = this.id,
    name = this.name,
    rotationPeriod = this.rotationPeriod,
    orbitalPeriod = this.orbitalPeriod,
    diameter = this.diameter,
    climate = this.climate,
    gravity = this.gravity,
    terrain = this.terrain,
    surfaceWater = this.surfaceWater,
    population = this.population,
    residents = this.residents,
    films = this.films
)

fun SpeciesModel.mapToSpeciesEntity() = SpeciesEntity(
    id = this.id,
    name = this.name,
    classification = this.classification,
    designation = this.designation,
    averageHeight = this.averageHeight,
    skinColors = this.skinColors,
    hairColors = this.hairColors,
    eyeColors = this.eyeColors,
    avgLifespan = this.avgLifespan,
    homeworld = this.homeworld,
    language = this.language,
    people = this.people,
    films = this.films
)

fun StarShipModel.mapToStarshipEntity() = StarShipEntity(
    id = this.id,
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
    pilots = this.pilots,
    films = this.films
)

fun VehicleModel.mapToVehicleEntity() = VehicleEntity(
    id = this.id,
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
    pilots = this.pilots,
    films = this.films
)

fun CharacterEntity.mapToCharacter() = CharacterModel(
    id = this.id,
    name = this.name,
    height = this.height,
    mass = this.mass,
    hairColor = this.hairColor,
    skinColor = this.skinColor,
    eyeColor = this.eyeColor,
    birthYear = this.birthYear,
    gender = this.gender,
    homeWorld = this.homeWorld,
    films = this.films,
    species = this.species,
    vehicles = this.vehicles,
    starships = this.starships
)

fun FilmEntity.mapToFilm() = FilmModel(
    id = this.id,
    title = this.title,
    episodeId = this.episodeId,
    openingCrawl = this.openingCrawl,
    director = this.director,
    producer = this.producer,
    releaseDate = this.releaseDate,
    characters = this.characters,
    planets = this.planets,
    starships = this.starships,
    vehicles = this.vehicles,
    species = this.species
)

fun PlanetEntity.mapToPlanet() = PlanetModel(
    id = this.id,
    name = this.name,
    rotationPeriod = this.rotationPeriod,
    orbitalPeriod = this.orbitalPeriod,
    diameter = this.diameter,
    climate = this.climate,
    gravity = this.gravity,
    terrain = this.terrain,
    surfaceWater = this.surfaceWater,
    population = this.population,
    residents = this.residents,
    films = this.films
)

fun SpeciesEntity.mapToSpecies() = SpeciesModel(
    id = this.id,
    name = this.name,
    classification = this.classification,
    designation = this.designation,
    averageHeight = this.averageHeight,
    skinColors = this.skinColors,
    hairColors = this.hairColors,
    eyeColors = this.eyeColors,
    avgLifespan = this.avgLifespan,
    homeworld = this.homeworld,
    language = this.language,
    people = this.people,
    films = this.films
)

fun StarShipEntity.mapToStarship() = StarShipModel(
    id = this.id,
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
    pilots = this.pilots,
    films = this.films
)

fun VehicleEntity.mapToVehicle() = VehicleModel(
    id = this.id,
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
    pilots = this.pilots,
    films = this.films
)
