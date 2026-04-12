package com.example.domain.utils

sealed class NetworkResponse<out T> {
    data class Success<T>(val data: T) : NetworkResponse<T>()
    data class Error(val code: Int, val message: String) : NetworkResponse<Nothing>()
    data class Exception(val e: Throwable) : NetworkResponse<Nothing>()
}