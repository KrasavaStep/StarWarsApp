package com.example.starwarsapp.screens.list_screen

data class ListState(
    val data: List<DataModel>? = null,
    val title: String? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

data class DataModel(
    val title: String,
    val additionalInfo: String
)