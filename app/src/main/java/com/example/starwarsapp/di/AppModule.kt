package com.example.starwarsapp.di

import com.example.domain.utils.CategoryName
import com.example.starwarsapp.screens.details_screen.DetailsViewModel
import com.example.starwarsapp.screens.home_screen.HomeScreenViewModel
import com.example.starwarsapp.screens.list_screen.ItemListViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module

val appModule = module {

    viewModel(named("home_vm")) {
        HomeScreenViewModel(
            fetchNetworkUseCase = get(),
            addDataToPrefsUseCase = get(),
            getDataFromPrefsUseCase = get()
        )
    }

    viewModel(named("list_vm")) { (tag: CategoryName) ->
        ItemListViewModel(
            tag,
            get(),
            get(),
            get(),
            get(),
            get(),
            get())
    }

    viewModel(named("details_vm")) { (tag: CategoryName, id: Int) ->
        DetailsViewModel(
            tag,
            id,
            get()
        )
    }

}