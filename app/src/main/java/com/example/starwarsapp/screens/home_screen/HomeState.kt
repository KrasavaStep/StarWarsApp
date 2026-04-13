package com.example.starwarsapp.screens.home_screen

data class HomeState(
    val isLoading: Boolean = false,
    val data: Boolean? = null,
    val error: String? = null,
    val isOffline: Boolean = false
)
