package com.example.data.di

import android.app.Application
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.data.data.database.StarWarsDao
import com.example.data.data.database.StarWarsDatabase
import org.koin.core.qualifier.named
import org.koin.dsl.module

fun provideDatabase(application: Application): StarWarsDatabase {
    return Room.databaseBuilder(application, StarWarsDatabase::class.java, "sw_db")
        .setJournalMode(RoomDatabase.JournalMode.TRUNCATE)
        .build()
}

fun provideDao(db: StarWarsDatabase): StarWarsDao {
    return db.getDao()
}

val databaseModule = module {
    single { provideDatabase(get()) }
    single { provideDao(get()) }
}