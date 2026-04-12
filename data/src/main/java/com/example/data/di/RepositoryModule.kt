package com.example.data.di

import com.example.data.data.database.StarWarsDao
import com.example.data.data.network.StarWarsApi
import com.example.data.repositories.NetworkRepositoryImpl
import com.example.domain.repositories.NetworkRepository
import org.koin.dsl.module

val repositoryModule = module {

    single<NetworkRepository> {
        NetworkRepositoryImpl(
            get<StarWarsApi>(),
            get<StarWarsDao>()
        )
    }

}