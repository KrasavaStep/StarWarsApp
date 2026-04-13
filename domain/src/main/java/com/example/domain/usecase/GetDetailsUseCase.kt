package com.example.domain.usecase

import com.example.domain.models.Id
import com.example.domain.repositories.CharacterRepository
import com.example.domain.repositories.FilmRepository
import com.example.domain.repositories.PlanetRepository
import com.example.domain.repositories.SpeciesRepository
import com.example.domain.repositories.StarshipRepository
import com.example.domain.repositories.VehicleRepository
import com.example.domain.utils.CategoryName
import com.example.domain.utils.DetailModel
import com.example.domain.utils.ExtraSection
import com.example.domain.utils.Film
import com.example.domain.utils.People
import com.example.domain.utils.Planet
import com.example.domain.utils.Species
import com.example.domain.utils.StarShip
import com.example.domain.utils.Vehicle

class GetDetailsUseCase(
    private val charRepo: CharacterRepository,
    private val filmRepo: FilmRepository,
    private val planetRepo: PlanetRepository,
    private val speciesRepo: SpeciesRepository,
    private val shipsRepo: StarshipRepository,
    private val vehicleRepo: VehicleRepository
) {

    suspend operator fun invoke(category: CategoryName, itemId: Id): DetailModel {
        when (category) {
            CategoryName.PEOPLE -> {
                val p = charRepo.getCharactersById(listOf(itemId))[0]
                val films = filmRepo.getFilmsById(p.films).map { it.title }
                val starships = shipsRepo.getStarshipById(p.starships).map { it.name }
                val vehicles = vehicleRepo.getVehiclesById(p.vehicles).map { it.name }
                val homeWorld = planetRepo.getPlanetById(listOf(p.homeWorld))[0]
                return DetailModel(
                    name = p.name,
                    info = mapOf(
                        People.HEIGH to p.height,
                        People.EYE to p.eyeColor,
                        People.MASS to p.mass,
                        People.HAIR to p.hairColor,
                        People.SKIN to p.skinColor,
                        People.BIRTH to p.birthYear,
                        People.GENDER to p.gender,
                        People.HOME to homeWorld.name
                    ),
                    extraLists = listOf(
                        ExtraSection(CategoryName.FILMS.titleName, films),
                        ExtraSection(CategoryName.STARSHIPS.titleName, starships),
                        ExtraSection(CategoryName.VEHICLES.titleName, vehicles)
                    )
                )
            }

            CategoryName.PLANETS -> {
                val p = planetRepo.getPlanetById(listOf(itemId))[0]
                val films = filmRepo.getFilmsById(p.films).map { it.title }
                val residents = charRepo.getCharactersById(p.residents).map { it.name }
                return DetailModel(
                    name = p.name,
                    info = mapOf(
                        Planet.ROTATION to p.rotationPeriod,
                        Planet.ORBITAL to p.orbitalPeriod,
                        Planet.DIAMETER to p.diameter,
                        Planet.CLIMATE to p.climate,
                        Planet.GRAVITY to p.gravity,
                        Planet.TERRAIN to p.terrain,
                        Planet.WATER to p.surfaceWater,
                        Planet.POPULATION to p.population
                    ),
                    extraLists = listOf(
                        ExtraSection(CategoryName.FILMS.titleName, films),
                        ExtraSection(CategoryName.PEOPLE.titleName, residents),
                    )
                )
            }

            CategoryName.STARSHIPS -> {
                val p = shipsRepo.getStarshipById(listOf(itemId))[0]
                val films = filmRepo.getFilmsById(p.films).map { it.title }
                val pilots = charRepo.getCharactersById(p.pilots).map { it.name }
                return DetailModel(
                    name = p.name,
                    info = mapOf(
                        StarShip.MODEL to p.model,
                        StarShip.MANUFACTURER to p.manufacturer,
                        StarShip.COST to p.cost,
                        StarShip.LENGTH to p.length,
                        StarShip.MAX_SPEED to p.maxSpeed,
                        StarShip.CREW to p.crew,
                        StarShip.PASSENGERS to p.passengers,
                        StarShip.CAPACITY to p.cargoCapacity,
                        StarShip.CONSUMABLES to p.consumables,
                        StarShip.HD_RATING to p.hyperdriveRating,
                        StarShip.MGLT to p.mglt,
                        StarShip.CLASS to p.starshipClass
                    ),
                    extraLists = listOf(
                        ExtraSection(CategoryName.FILMS.titleName, films),
                        ExtraSection(CategoryName.PEOPLE.titleName, pilots),
                    )
                )
            }

            CategoryName.VEHICLES -> {
                val p = vehicleRepo.getVehiclesById(listOf(itemId))[0]
                val films = filmRepo.getFilmsById(p.films).map { it.title }
                val pilots = charRepo.getCharactersById(p.pilots).map { it.name }
                return DetailModel(
                    name = p.name,
                    info = mapOf(
                        Vehicle.MODEL to p.model,
                        Vehicle.MANUFACTURER to p.manufacturer,
                        Vehicle.COST to p.cost,
                        Vehicle.LENGTH to p.length,
                        Vehicle.MAX_SPEED to p.maxSpeed,
                        Vehicle.CREW to p.crew,
                        Vehicle.PASSENGERS to p.passengers,
                        Vehicle.CAPACITY to p.cargoCapacity,
                        Vehicle.CONSUMABLES to p.consumables,
                        Vehicle.CLASS to p.vehicleClass
                    ),
                    extraLists = listOf(
                        ExtraSection(CategoryName.FILMS.titleName, films),
                        ExtraSection(CategoryName.PEOPLE.titleName, pilots),
                    )
                )
            }

            CategoryName.SPECIES -> {
                val p = speciesRepo.getSpeciesById(listOf(itemId))[0]
                val films = filmRepo.getFilmsById(p.films).map { it.title }
                val people = charRepo.getCharactersById(p.people).map { it.name }
                val homeWorld = if (p.homeworld != null) {
                    planetRepo.getPlanetById(listOf(p.homeworld))[0].name
                } else {
                    ""
                }

                return DetailModel(
                    name = p.name,
                    info = mapOf(
                        Species.CLASSIFICATION to p.classification,
                        Species.DESIGNATION to p.designation,
                        Species.AVG_HEIGHT to p.averageHeight,
                        Species.SKIN to p.skinColors,
                        Species.HAIR to p.hairColors,
                        Species.EYE to p.eyeColors,
                        Species.AVG_LIFESPAN to p.avgLifespan,
                        Species.HOMEWORLD to homeWorld,
                        Species.LANGUAGE to p.language
                    ),
                    extraLists = listOf(
                        ExtraSection(CategoryName.FILMS.titleName, films),
                        ExtraSection(CategoryName.PEOPLE.titleName, people),
                    )
                )
            }

            CategoryName.FILMS -> {
                val p = filmRepo.getFilmsById(listOf(itemId))[0]
                val planets = planetRepo.getPlanetById(p.planets).map { it.name }
                val people = charRepo.getCharactersById(p.characters).map { it.name }
                val vehicles = vehicleRepo.getVehiclesById(p.vehicles).map { it.name }
                val starships = shipsRepo.getStarshipById(p.starships).map { it.name }
                val species = speciesRepo.getSpeciesById(p.species).map { it.name }

                return DetailModel(
                    name = p.title,
                    info = mapOf(
                        Film.EPISODE_ID to p.episodeId.toString(),
                        Film.CRAWL to p.openingCrawl,
                        Film.DIRECTOR to p.director,
                        Film.PRODUCER to p.producer,
                        Film.RELEASE to p.releaseDate
                    ),
                    extraLists = listOf(
                        ExtraSection(CategoryName.PLANETS.titleName, planets),
                        ExtraSection(CategoryName.PEOPLE.titleName, people),
                        ExtraSection(CategoryName.VEHICLES.titleName, vehicles),
                        ExtraSection(CategoryName.STARSHIPS.titleName, starships),
                        ExtraSection(CategoryName.SPECIES.titleName, species),
                    )
                )
            }
        }
    }

}