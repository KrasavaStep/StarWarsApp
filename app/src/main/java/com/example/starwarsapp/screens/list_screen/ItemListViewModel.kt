package com.example.starwarsapp.screens.list_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.GetCharactersUseCase
import com.example.domain.usecase.GetFilmsUseCase
import com.example.domain.usecase.GetPlanetUseCase
import com.example.domain.usecase.GetSpeciesUseCase
import com.example.domain.usecase.GetStarshipUseCase
import com.example.domain.usecase.GetVehicleUseCase
import com.example.domain.utils.CategoryName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class ItemListViewModel(
    private val tag: CategoryName,
    private val getPlanetUseCase: GetPlanetUseCase,
    private val getFilmsUseCase: GetFilmsUseCase,
    private val getCharactersUseCase: GetCharactersUseCase,
    private val getStarshipUseCase: GetStarshipUseCase,
    private val getVehicleUseCase: GetVehicleUseCase,
    private val getSpeciesUseCase: GetSpeciesUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(ListState())
    val state: StateFlow<ListState> = _state.asStateFlow()

    init {
        loadData()
    }

    //TODO rework for one use case
    private fun loadData() {
        viewModelScope.launch(Dispatchers.IO) {
            _state.update { it.copy(isLoading = true, error = null) }

            when (tag) {
                CategoryName.PEOPLE -> {
                    val data = getCharactersUseCase().map { model ->
                        val additionalInfo = "Height: ${model.height}cm, Mass: ${model.mass}kg, Hair: ${model.hairColor}, Eyes: ${model.eyeColor}"
                        DataModel(id = model.id, title = model.name, additionalInfo = additionalInfo)
                    }
                    _state.update { it.copy(isLoading = false, data = data, title = tag.titleName) }
                }

                CategoryName.PLANETS -> {
                    val data = getPlanetUseCase().map { model ->
                        val additionalInfo = "Rotation period: ${model.rotationPeriod}d, OrbitalPeriod: ${model.orbitalPeriod}d, Climate: ${model.climate}"
                        DataModel(id = model.id, title = model.name, additionalInfo = additionalInfo)
                    }
                    _state.update { it.copy(isLoading = false, data = data, title = tag.titleName) }
                }

                CategoryName.STARSHIPS -> {
                    val data = getStarshipUseCase().map { model ->
                        val additionalInfo = "Model: ${model.model}, Cost: ${model.cost}"
                        DataModel(id = model.id, title = model.name, additionalInfo = additionalInfo)
                    }
                    _state.update { it.copy(isLoading = false, data = data, title = tag.titleName) }
                }

                CategoryName.VEHICLES -> {
                    val data = getVehicleUseCase().map { model ->
                        val additionalInfo = "Model: ${model.model}, Cost: ${model.cost}"
                        DataModel(id = model.id, title = model.name, additionalInfo = additionalInfo)
                    }
                    _state.update { it.copy(isLoading = false, data = data, title = tag.titleName) }
                }

                CategoryName.SPECIES -> {
                    val data = getSpeciesUseCase().map { model ->
                        val additionalInfo = "Classification: ${model.classification}, Avg. lifespan: ${model.avgLifespan}y"
                        DataModel(id = model.id, title = model.name, additionalInfo = additionalInfo)
                    }
                    _state.update { it.copy(isLoading = false, data = data, title = tag.titleName) }
                }

                CategoryName.FILMS -> {
                    val data = getFilmsUseCase().map { model ->
                        val additionalInfo = "Release date: ${model.releaseDate}"
                        DataModel(id = model.id, title = model.title, additionalInfo = additionalInfo)
                    }
                    _state.update { it.copy(isLoading = false, data = data, title = tag.titleName) }
                }
            }
        }
    }


}