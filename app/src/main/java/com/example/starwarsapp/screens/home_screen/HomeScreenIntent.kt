package com.example.starwarsapp.screens.home_screen

sealed interface HomeScreenIntent {
    object LoadAllData : HomeScreenIntent
    object RefreshData : HomeScreenIntent

    object ClearError: HomeScreenIntent
}