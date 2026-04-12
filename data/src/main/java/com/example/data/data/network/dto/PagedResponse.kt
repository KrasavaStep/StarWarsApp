package com.example.data.data.network.dto

import com.google.gson.annotations.SerializedName

data class PagedResponse<T>(
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<T>
)
