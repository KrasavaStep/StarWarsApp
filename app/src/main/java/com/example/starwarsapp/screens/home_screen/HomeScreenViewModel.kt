package com.example.starwarsapp.screens.home_screen

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.usecase.FetchNetworkUseCase
import com.example.domain.usecase.GetFromPrefsUseCase
import com.example.domain.usecase.SaveToPrefsUseCase
import com.example.domain.utils.NetworkResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

class HomeScreenViewModel(
    private val fetchNetworkUseCase: FetchNetworkUseCase,
    private val addDataToPrefsUseCase: SaveToPrefsUseCase,
    private val getDataFromPrefsUseCase: GetFromPrefsUseCase
) : ViewModel() {

    private val sharedPrefsKey = "isFirstTime"

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state.asStateFlow()

    /**
     * start check if user launch not for first time
     * **/
    init {
        if (getDataFromPrefsUseCase(sharedPrefsKey)) {
            _state.update { it.copy(isLoading = false, data = true) }
        }
    }

    fun handleIntent(intent: HomeScreenIntent) {
        when (intent) {
            is HomeScreenIntent.LoadAllData -> {
                if (getDataFromPrefsUseCase(sharedPrefsKey)) {
                    _state.update { it.copy(isLoading = false, data = true) }
                } else {
                    fetchData()
                }
            }

            is HomeScreenIntent.RefreshData -> fetchData()
            is HomeScreenIntent.ClearError -> {
                _state.update {
                    it.copy(error = null)
                }
            }
        }
    }

    /**
     * Fetch all data from the API
     * **/
    fun fetchData() {
        viewModelScope.launch(Dispatchers.IO) {

            _state.update { it.copy(isLoading = true, error = null) }

            try {
                when (val response = fetchNetworkUseCase()) {
                    is NetworkResponse.Success -> {
                        _state.update { it.copy(isLoading = false, data = response.data) }
                        addDataToPrefsUseCase(sharedPrefsKey, true)
                    }

                    is NetworkResponse.Exception -> {
                        Log.e("Response Error", response.e.message.toString())
                        _state.update { it.copy(isLoading = false, error = response.e.message) }
                    }
                }
            } catch (e: Exception) {
                val isNetworkError = e is java.net.UnknownHostException || e is java.io.IOException
                _state.update {
                    it.copy(
                        isLoading = false,
                        isOffline = isNetworkError,
                        error = e.message
                    )
                }


            }
        }
    }
}