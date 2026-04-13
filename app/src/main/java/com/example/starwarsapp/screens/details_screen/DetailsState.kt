package com.example.starwarsapp.screens.details_screen

import com.example.domain.utils.DetailModel

data class DetailsState(
    val isLoading: Boolean = true,
    val data: DetailModel? = null,
    val error: String? = null
)