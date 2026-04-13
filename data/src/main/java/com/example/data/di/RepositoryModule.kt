package com.example.data.di

import com.example.data.data.database.StarWarsDao
import com.example.data.data.network.StarWarsApi
import com.example.data.repositories.CharacterRepositoryImpl
import com.example.data.repositories.FilmRepositoryImpl
import com.example.data.repositories.NetworkRepositoryImpl
import com.example.data.repositories.PlanetRepositoryImpl
import com.example.data.repositories.SharedPrefsRepositoryImpl
import com.example.data.repositories.SpeciesRepositoryImpl
import com.example.data.repositories.StarshipRepositoryImpl
import com.example.data.repositories.VehicleRepositoryImpl
import com.example.domain.repositories.CharacterRepository
import com.example.domain.repositories.FilmRepository
import com.example.domain.repositories.NetworkRepository
import com.example.domain.repositories.PlanetRepository
import com.example.domain.repositories.SharedPrefsRepository
import com.example.domain.repositories.SpeciesRepository
import com.example.domain.repositories.StarshipRepository
import com.example.domain.repositories.VehicleRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<NetworkRepository> {
        NetworkRepositoryImpl(
            get<StarWarsApi>(),
            get<StarWarsDao>()
        )
    }

    single<SharedPrefsRepository> {
        SharedPrefsRepositoryImpl(get())
    }

    single<CharacterRepository> {
        CharacterRepositoryImpl(get())
    }

    single<FilmRepository> {
        FilmRepositoryImpl(get())
    }

    single<PlanetRepository> {
        PlanetRepositoryImpl(get())
    }

    single<SpeciesRepository> {
        SpeciesRepositoryImpl(get())
    }

    single<StarshipRepository> {
        StarshipRepositoryImpl(get())
    }

    single<VehicleRepository> {
        VehicleRepositoryImpl(get())
    }


}