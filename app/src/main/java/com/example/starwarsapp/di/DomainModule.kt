package com.example.starwarsapp.di

import com.example.domain.usecase.FetchNetworkUseCase
import org.koin.dsl.module

val domainModule = module {

    factory { FetchNetworkUseCase(get()) }

}