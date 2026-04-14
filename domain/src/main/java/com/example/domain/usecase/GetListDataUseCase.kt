package com.example.domain.usecase

import com.example.domain.repositories.CharacterRepository
import com.example.domain.repositories.FilmRepository
import com.example.domain.repositories.PlanetRepository
import com.example.domain.repositories.SpeciesRepository
import com.example.domain.repositories.StarshipRepository
import com.example.domain.repositories.VehicleRepository
import com.example.domain.utils.CategoryName
import com.example.domain.utils.Film
import com.example.domain.utils.ListModel
import com.example.domain.utils.People
import com.example.domain.utils.Planet
import com.example.domain.utils.Species
import com.example.domain.utils.StarShip
import com.example.domain.utils.Vehicle

class GetListDataUseCase(
    private val charRepo: CharacterRepository,
    private val filmRepo: FilmRepository,
    private val planetRepo: PlanetRepository,
    private val speciesRepo: SpeciesRepository,
    private val shipsRepo: StarshipRepository,
    private val vehicleRepo: VehicleRepository
) {

    suspend operator fun invoke(category: CategoryName): List<ListModel> {
        when (category) {
            CategoryName.PEOPLE -> {
                val data = charRepo.getCharacters().map { item ->
                    ListModel(
                        id = item.id,
                        name = item.name,
                        info = mapOf(
                            People.HEIGH to item.height,
                            People.EYE to item.eyeColor,
                            People.MASS to item.mass,
                            People.HAIR to item.hairColor,
                        )
                    )
                }
                return data
            }

            CategoryName.PLANETS -> {
                val data = planetRepo.getPlanets().map { item ->
                    ListModel(
                        id = item.id,
                        name = item.name,
                        info = mapOf(
                            Planet.ROTATION to item.rotationPeriod,
                            Planet.ORBITAL to item.orbitalPeriod,
                            Planet.CLIMATE to item.climate,
                        )
                    )
                }
                return data
            }

            CategoryName.STARSHIPS -> {
                val data = shipsRepo.getStarships().map { item ->
                    ListModel(
                        id = item.id,
                        name = item.name,
                        info = mapOf(
                            StarShip.MODEL to item.model,
                            StarShip.COST to item.cost,
                        )
                    )
                }
                return data
            }

            CategoryName.VEHICLES -> {
                val data = vehicleRepo.getVehicles().map { item ->
                    ListModel(
                        id = item.id,
                        name = item.name,
                        info = mapOf(
                            Vehicle.MODEL to item.model,
                            Vehicle.COST to item.cost,
                        )
                    )
                }
                return data
            }

            CategoryName.SPECIES -> {
                val data = speciesRepo.getSpecies().map { item ->
                    ListModel(
                        id = item.id,
                        name = item.name,
                        info = mapOf(
                            Species.CLASSIFICATION to item.classification,
                            Species.AVG_LIFESPAN to item.avgLifespan,
                        )
                    )
                }
                return data
            }

            CategoryName.FILMS -> {
                val data = filmRepo.getFilms().map { item ->
                    ListModel(
                        id = item.id,
                        name = item.title,
                        info = mapOf(
                            Film.RELEASE to item.releaseDate,
                        )
                    )
                }
                return data
            }
        }
    }
}