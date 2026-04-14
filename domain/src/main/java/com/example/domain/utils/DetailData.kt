package com.example.domain.utils

import com.example.domain.models.Id

data class DetailModel(
    val name: String,
    val info: Map<Key, String>,
    val extraLists: List<ExtraSection>
)

data class ExtraSection(
    val title: String,
    val items: List<String>
)


