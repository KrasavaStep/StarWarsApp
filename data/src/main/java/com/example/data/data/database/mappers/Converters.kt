package com.example.data.data.database.mappers

import androidx.room.TypeConverter
import com.example.domain.models.Id
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {
    @TypeConverter
    fun fromList(list: List<Id>?): String? {
        return Gson().toJson(list)
    }

    @TypeConverter
    fun toList(data: String?): List<Id>? {
        val listType = object : TypeToken<List<Id>>() {}.type
        return Gson().fromJson(data, listType)
    }
}