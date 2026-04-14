package com.example.starwarsapp.util

import com.example.domain.utils.Film
import com.example.domain.utils.Key
import com.example.domain.utils.People
import com.example.domain.utils.Planet
import com.example.domain.utils.Species
import com.example.domain.utils.StarShip
import com.example.domain.utils.Vehicle

fun getNameForEnum(k: Key): String {

    return when (k) {
        Film.TITLE -> "Title"
        Film.EPISODE_ID -> "Episode number"
        Film.CRAWL -> "Opening crawl"
        Film.DIRECTOR -> "Director"
        Film.PRODUCER -> "Producer"
        Film.RELEASE -> "Release date"
        People.NAME -> "Name"
        People.HEIGH -> "Heigh, cm"
        People.MASS -> "Mas, kg"
        People.HAIR -> "Hair color"
        People.SKIN -> "Skin color"
        People.EYE -> "Eyes color"
        People.BIRTH -> "Birth date"
        People.GENDER -> "Gender"
        People.HOME -> "Home world"
        Planet.NAME -> "Name"
        Planet.ROTATION -> "Rotation period"
        Planet.ORBITAL -> "Orbital period"
        Planet.DIAMETER -> "Diameter"
        Planet.CLIMATE -> "Climate"
        Planet.GRAVITY -> "Gravity"
        Planet.TERRAIN -> "Terrain"
        Planet.WATER -> "Water"
        Planet.POPULATION -> "Population"
        Species.NAME -> "Name"
        Species.CLASSIFICATION -> "Classification"
        Species.DESIGNATION -> "Designation"
        Species.AVG_HEIGHT -> "Average height, cm"
        Species.SKIN -> "Skin color"
        Species.HAIR -> "Hair color"
        Species.EYE -> "Eyes color"
        Species.AVG_LIFESPAN -> "Average lifespan, y"
        Species.HOMEWORLD -> "Home world"
        Species.LANGUAGE -> "Language"
        StarShip.NAME -> "Name"
        StarShip.MODEL -> "Model"
        StarShip.MANUFACTURER -> "Manufacturer"
        StarShip.COST -> "Cost"
        StarShip.LENGTH -> "Length"
        StarShip.MAX_SPEED -> "Max. speed"
        StarShip.CREW -> "Crew"
        StarShip.PASSENGERS -> "Passengers"
        StarShip.CAPACITY -> "Capacity"
        StarShip.CONSUMABLES -> "Consumables"
        StarShip.HD_RATING -> "Hyperdrive rating"
        StarShip.MGLT -> "MGLT"
        StarShip.CLASS -> "Starship class"
        Vehicle.NAME -> "Name"
        Vehicle.MODEL -> "Model"
        Vehicle.MANUFACTURER -> "Manufacturer"
        Vehicle.COST -> "Cost"
        Vehicle.LENGTH -> "Length"
        Vehicle.MAX_SPEED -> "Max. speed"
        Vehicle.CREW -> "Crew"
        Vehicle.PASSENGERS -> "Passengers"
        Vehicle.CAPACITY -> "Capacity"
        Vehicle.CONSUMABLES -> "Consumables"
        Vehicle.CLASS -> "Vehicle class"
    }
}