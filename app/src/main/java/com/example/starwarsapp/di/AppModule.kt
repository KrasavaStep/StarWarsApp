package com.example.starwarsapp.di

import com.example.starwarsapp.screens.home_screen.HomeScreenViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    viewModel(named("home_vm")) {
        HomeScreenViewModel(fetchNetworkUseCase = get())
    }

}