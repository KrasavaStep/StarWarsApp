package com.example.starwarsapp.screens.list_screen
import com.example.domain.utils.ListModel

data class ListState(
    val data: List<ListModel>? = null,
    val title: String? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)