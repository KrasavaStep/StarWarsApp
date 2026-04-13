package com.example.domain.repositories

interface SharedPrefsRepository {

    fun addDataToPrefs(key: String, value: Boolean)

    fun getDataFromPrefs(key: String): Boolean

}