package com.example.starwarsapp.screens.home_screen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun HomeScreen(viewModel: HomeScreenViewModel) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when {
            state.isLoading -> {
                CircularProgressIndicator()
            }
            state.error != null -> {
                Column() {
                    Text(state.error.toString())
                    Button(onClick = {
                        viewModel.handleIntent(HomeScreenIntent.RefreshData)
                    }) {
                        Text("Попробовать снова")
                    }
                }
            }
            state.data != null -> {
                Text(state.data.toString())
            }
            else -> {
                Button(onClick = { viewModel.handleIntent(HomeScreenIntent.LoadAllData) }) {
                    Text("Загрузить данные Star Wars")
                }
            }
        }
    }
}