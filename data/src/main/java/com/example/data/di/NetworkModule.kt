package com.example.data.di

import com.example.data.data.network.StarWarsApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val networkModule = module {
    single<HttpLoggingInterceptor> {
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    single<Retrofit>(named("SW_API")) {
        Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(StarWarsApi.STAR_WARS_API_URL)
            .client(get())
            .build()
    }

    single<OkHttpClient> {
        val httpClient = OkHttpClient.Builder()
        httpClient.build()

        //TODO
        /*if (BuildConfig.DEBUG){
            OkHttpClient.Builder().addInterceptor((get<HttpLoggingInterceptor>())).build()
        }*/
        //else{
            OkHttpClient.Builder().build()
        //}
    }

    single<StarWarsApi> {
        (get<Retrofit>(named("SW_API"))).create(StarWarsApi::class.java)
    }
}