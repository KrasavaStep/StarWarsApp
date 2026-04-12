package com.example.starwarsapp.screens.home_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.FetchNetworkUseCase
import com.example.domain.utils.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val fetchNetworkUseCase: FetchNetworkUseCase
): ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    fun handleIntent(intent: HomeScreenIntent) {
        when (intent) {
            is HomeScreenIntent.LoadAllData, is HomeScreenIntent.RefreshData -> fetchData()
        }
    }

    fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {

            _state.update { it.copy(isLoading = true, error = null) }

            when (val response = fetchNetworkUseCase()) {
                is NetworkResponse.Success -> {
                    _state.update { it.copy(isLoading = false, data = response.data) }
                }
                is NetworkResponse.Exception -> {
                    Log.e("Response Error", response.e.message.toString())
                    _state.update { it.copy(isLoading = false, error = response.e.message) }
                }
            }

        }
    }

}