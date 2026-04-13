package com.example.starwarsapp.di

import com.example.domain.usecase.FetchNetworkUseCase
import com.example.domain.usecase.GetCharactersUseCase
import com.example.domain.usecase.GetFilmsUseCase
import com.example.domain.usecase.GetFromPrefsUseCase
import com.example.domain.usecase.GetPlanetUseCase
import com.example.domain.usecase.GetSpeciesUseCase
import com.example.domain.usecase.GetStarshipUseCase
import com.example.domain.usecase.GetVehicleUseCase
import com.example.domain.usecase.SaveToPrefsUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { FetchNetworkUseCase(get()) }

    factory { GetFromPrefsUseCase(get()) }

    factory { SaveToPrefsUseCase(get()) }

    factory { GetCharactersUseCase(get()) }
    factory { GetFilmsUseCase(get()) }
    factory { GetVehicleUseCase(get()) }
    factory { GetPlanetUseCase(get()) }
    factory { GetStarshipUseCase(get()) }
    factory { GetSpeciesUseCase(get()) }

}