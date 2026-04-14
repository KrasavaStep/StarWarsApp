package com.example.domain.utils

import com.example.domain.models.Id

data class ListModel(
    val id: Id,
    val name: String,
    val info: Map<Key, String>
)