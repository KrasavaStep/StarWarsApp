package com.example.starwarsapp.di

import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {
    viewModel<>(named("networkVM")){
        (repository = get())
    }

}