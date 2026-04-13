package com.example.domain.utils

data class DetailModel(
    val name: String,
    val info: Map<Key, String>,
    val extraLists: List<ExtraSection>
)

data class ExtraSection(
    val title: String,
    val items: List<String>
)

sealed interface Key

enum class People : Key {
    NAME, HEIGH, MASS, HAIR, SKIN, EYE, BIRTH, GENDER, HOME
}

enum class Film : Key {
    TITLE, EPISODE_ID, CRAWL, DIRECTOR, PRODUCER, RELEASE
}

enum class Planet : Key {
    NAME, ROTATION, ORBITAL, DIAMETER, CLIMATE, GRAVITY, TERRAIN, WATER, POPULATION
}

enum class Species : Key {
    NAME, CLASSIFICATION, DESIGNATION, AVG_HEIGHT, SKIN, HAIR, EYE, AVG_LIFESPAN, HOMEWORLD, LANGUAGE
}

enum class StarShip : Key {
    NAME, MODEL, MANUFACTURER, COST, LENGTH, MAX_SPEED, CREW, PASSENGERS, CAPACITY, CONSUMABLES, HD_RATING, MGLT, CLASS
}

enum class Vehicle : Key {
    NAME, MODEL, MANUFACTURER, COST, LENGTH, MAX_SPEED, CREW, PASSENGERS, CAPACITY, CONSUMABLES, CLASS
}



