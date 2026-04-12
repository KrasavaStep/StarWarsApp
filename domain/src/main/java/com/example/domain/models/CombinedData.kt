package com.example.domain.models

data class CombinedData(
    val characters: List<CharacterModel>,
    val films: List<FilmModel>,
    val species: List<SpeciesModel>,
    val starships: List<StarShipModel>,
    val vehicles: List<VehicleModel>,
    val planets: List<PlanetModel>
)
