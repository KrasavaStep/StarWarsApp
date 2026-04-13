package com.example.data.repositories

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.example.domain.repositories.SharedPrefsRepository

class SharedPrefsRepositoryImpl(context: Context): SharedPrefsRepository {

    private val sharedPreferences: SharedPreferences =
        context.getSharedPreferences("my_prefs", Context.MODE_PRIVATE)

    override fun addDataToPrefs(key: String, value: Boolean) {
        sharedPreferences.edit { putBoolean(key, value) }
    }

    override fun getDataFromPrefs(key: String): Boolean {
        return sharedPreferences.getBoolean(key, false)
    }
}