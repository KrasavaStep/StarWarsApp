package com.example.data.repositories

import com.example.data.data.database.StarWarsDao
import com.example.data.data.database.mappers.mapToCharacterEntity
import com.example.data.data.database.mappers.mapToFilmEntity
import com.example.data.data.database.mappers.mapToPlanetEntity
import com.example.data.data.database.mappers.mapToSpeciesEntity
import com.example.data.data.database.mappers.mapToStarshipEntity
import com.example.data.data.database.mappers.mapToVehicleEntity
import com.example.data.data.network.StarWarsApi
import com.example.data.data.network.dto.PagedResponse
import com.example.data.data.network.mappers.mapToCharacters
import com.example.data.data.network.mappers.mapToFilm
import com.example.data.data.network.mappers.mapToPlanet
import com.example.data.data.network.mappers.mapToSpecies
import com.example.data.data.network.mappers.mapToStarship
import com.example.data.data.network.mappers.mapToVehicle
import com.example.domain.models.CombinedData
import com.example.domain.repositories.NetworkRepository
import com.example.domain.utils.NetworkResponse
import kotlinx.coroutines.async
import kotlinx.coroutines.coroutineScope
import retrofit2.Response

class NetworkRepositoryImpl(
    private val api: StarWarsApi,
    private val dao: StarWarsDao
) : NetworkRepository {

    /**
     * This method getting all data from the API,
     * give that data to "saveToDb" method and
     * then its result converting to NetworkResponse
     * */

    override suspend fun fetchDataFromNetwork(): NetworkResponse<Boolean> {
        return coroutineScope {
            runCatching {
                val characters = async { fetchAllPages(
                    firstRequest = { api.getAllCharacters() },
                    nextRequest =  { url -> api.getCharactersByUrl(url) })
                }.await()
                val films = async { fetchAllPages(
                    firstRequest = { api.getAllFilms() },
                    nextRequest =  { url -> api.getFilmsByUrl(url) })
                }.await()
                val species = async { fetchAllPages(
                    firstRequest = { api.getAllSpecies() },
                    nextRequest =  { url -> api.getSpeciesByUrl(url) })
                }.await()
                val starships = async { fetchAllPages(
                    firstRequest = { api.getAllStarships() },
                    nextRequest =  { url -> api.getStarshipsByUrl(url) })
                }.await()
                val vehicles = async { fetchAllPages(
                    firstRequest = { api.getAllVehicles() },
                    nextRequest =  { url -> api.getVehiclesByUrl(url) })
                }.await()
                val planets = async { fetchAllPages(
                    firstRequest = { api.getAllPlanets() },
                    nextRequest =  { url -> api.getPlanetsByUrl(url) })
                }.await()

                val combine = CombinedData(
                    characters = characters.map { it.mapToCharacters() },
                    films = films.map { it.mapToFilm() },
                    species = species.map { it.mapToSpecies() },
                    starships = starships.map { it.mapToStarship() },
                    vehicles = vehicles.map { it.mapToVehicle() },
                    planets = planets.map { it.mapToPlanet() }
                )

                saveToDb(combine)

                NetworkResponse.Success(true)

            }.getOrElse { exception ->
                NetworkResponse.Exception(exception)
            }
        }
    }

    /**
     * This is helping method which is fetching all data
     * for request and throws exception if something went wrong.
     * */
    private suspend fun <T> fetchAllPages(
        firstRequest: suspend () -> Response<PagedResponse<T>>,
        nextRequest: suspend (String) -> Response<PagedResponse<T>>
    ): List<T> {
        val allResults = mutableListOf<T>()
        var nextUrl: String? = null

        try {
            val firstResponse = firstRequest()
            if (firstResponse.isSuccessful) {
                val body = firstResponse.body()
                body?.results?.let { allResults.addAll(it) }
                nextUrl = body?.next
            } else {
                throw Exception("${firstResponse.code()}: ${firstResponse.message()}")
            }

            while (nextUrl != null) {
                val response = nextRequest(nextUrl)
                if (response.isSuccessful) {
                    val body = response.body()
                    body?.results?.let { allResults.addAll(it) }
                    nextUrl = body?.next
                } else {
                    throw Exception("${response.code()}: ${response.message()}")
                }
            }
            return allResults
        } catch (e: Exception) {
            throw Exception(e)
        }
    }

    /**
     * This method is saving data to database
     * */
    private suspend fun saveToDb(combined: CombinedData) {
        dao.addCharactersData(combined.characters.map { it.mapToCharacterEntity() })
        dao.addFilmData(combined.films.map { it.mapToFilmEntity() })
        dao.addPlanetData(combined.planets.map { it.mapToPlanetEntity() })
        dao.addSpeciesData(combined.species.map { it.mapToSpeciesEntity() })
        dao.addVehicleData(combined.vehicles.map { it.mapToVehicleEntity() })
        dao.addStarshipData(combined.starships.map { it.mapToStarshipEntity() })
    }

}