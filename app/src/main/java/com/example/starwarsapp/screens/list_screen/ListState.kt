package com.example.starwarsapp.screens.list_screen

import com.example.domain.models.Id

data class ListState(
    val data: List<DataModel>? = null,
    val title: String? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)

data class DataModel(
    val id: Id,
    val title: String,
    val additionalInfo: String
)