package com.example.starwarsapp.util

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import com.example.domain.utils.Film
import com.example.domain.utils.Key
import com.example.domain.utils.People
import com.example.domain.utils.Planet
import com.example.domain.utils.Species
import com.example.domain.utils.StarShip
import com.example.domain.utils.Vehicle
import com.example.starwarsapp.R

@Composable
fun getStringForEnum(k: Key): String {
    val resId = when (k) {
        Film.TITLE -> R.string.film_title
        Film.EPISODE_ID -> R.string.label_episode_number
        Film.CRAWL -> R.string.label_opening_crawl
        Film.DIRECTOR -> R.string.label_director
        Film.PRODUCER -> R.string.label_producer
        Film.RELEASE -> R.string.label_release_date
        People.NAME -> R.string.label_name
        People.HEIGH -> R.string.label_height_cm
        People.MASS -> R.string.label_mass_kg
        People.HAIR -> R.string.label_hair_color
        People.SKIN -> R.string.label_skin_color
        People.EYE -> R.string.label_eyes_color
        People.BIRTH -> R.string.label_birth_date
        People.GENDER -> R.string.label_gender
        People.HOME -> R.string.label_home_world
        Planet.NAME -> R.string.label_name
        Planet.ROTATION -> R.string.label_rotation_period
        Planet.ORBITAL -> R.string.label_orbital_period
        Planet.DIAMETER -> R.string.label_diameter
        Planet.CLIMATE -> R.string.label_climate
        Planet.GRAVITY -> R.string.label_gravity
        Planet.TERRAIN -> R.string.label_terrain
        Planet.WATER -> R.string.label_water
        Planet.POPULATION -> R.string.label_population
        Species.NAME -> R.string.label_name
        Species.CLASSIFICATION -> R.string.label_classification
        Species.DESIGNATION -> R.string.label_designation
        Species.AVG_HEIGHT -> R.string.label_average_height_cm
        Species.SKIN -> R.string.label_skin_color
        Species.HAIR -> R.string.label_hair_color
        Species.EYE -> R.string.label_eyes_color
        Species.AVG_LIFESPAN -> R.string.label_average_lifespan_y
        Species.HOMEWORLD -> R.string.label_home_world
        Species.LANGUAGE -> R.string.label_language
        StarShip.NAME -> R.string.label_name
        StarShip.MODEL -> R.string.label_model
        StarShip.MANUFACTURER -> R.string.label_manufacturer
        StarShip.COST -> R.string.label_cost
        StarShip.LENGTH -> R.string.label_length
        StarShip.MAX_SPEED -> R.string.label_max_speed
        StarShip.CREW -> R.string.label_crew
        StarShip.PASSENGERS -> R.string.label_passengers
        StarShip.CAPACITY -> R.string.label_capacity
        StarShip.CONSUMABLES -> R.string.label_consumables
        StarShip.HD_RATING -> R.string.label_hyperdrive_rating
        StarShip.MGLT -> R.string.label_mglt
        StarShip.CLASS -> R.string.label_starship_class
        Vehicle.NAME -> R.string.label_name
        Vehicle.MODEL -> R.string.label_model
        Vehicle.MANUFACTURER -> R.string.label_manufacturer
        Vehicle.COST -> R.string.label_cost
        Vehicle.LENGTH -> R.string.label_length
        Vehicle.MAX_SPEED -> R.string.label_max_speed
        Vehicle.CREW -> R.string.label_crew
        Vehicle.PASSENGERS -> R.string.label_passengers
        Vehicle.CAPACITY -> R.string.label_capacity
        Vehicle.CONSUMABLES -> R.string.label_consumables
        Vehicle.CLASS -> R.string.label_vehicle_class
    }
    return stringResource(resId)
}