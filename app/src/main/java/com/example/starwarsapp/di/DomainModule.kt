package com.example.starwarsapp.di

import com.example.domain.usecase.FetchNetworkUseCase
import com.example.domain.usecase.GetDetailsUseCase
import com.example.domain.usecase.GetFromPrefsUseCase
import com.example.domain.usecase.GetListDataUseCase
import com.example.domain.usecase.SaveToPrefsUseCase
import org.koin.dsl.module

/**Koin module for use cases**/
val domainModule = module {

    factory { FetchNetworkUseCase(get()) }

    factory { GetFromPrefsUseCase(get()) }

    factory { SaveToPrefsUseCase(get()) }

    factory { GetDetailsUseCase(get(), get(), get(), get(), get(), get()) }
    factory { GetListDataUseCase(get(), get(), get(), get(), get(), get()) }

}