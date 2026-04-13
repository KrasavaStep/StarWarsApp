package com.example.starwarsapp.screens.list_screen

sealed interface ListIntent {
    object laodData : ListIntent
}