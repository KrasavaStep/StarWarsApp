package com.example.starwarsapp.screens.list_screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.domain.models.Id
import com.example.starwarsapp.screens.home_screen.ui.DeathStarLoader
import com.example.starwarsapp.screens.list_screen.ItemListViewModel

@Composable
fun ListScreen(
    viewModel: ItemListViewModel,
    onBackClick: () -> Unit,
    onItemClick: (tag: String, id: Id) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    if (state.isLoading) {
        DeathStarLoader()
    } else {
        var searchQuery by remember { mutableStateOf("") }

        val filteredContent = state.data?.filter {
            it.name.contains(searchQuery, ignoreCase = true)
        } ?: emptyList()

        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
        ) {

            ListScreenTitle(state.title.toString()) {
                onBackClick()
            }

            SearchBar(searchQuery) {
                searchQuery = it
            }

            Spacer(modifier = Modifier.height(8.dp))

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(16.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(filteredContent) {
                    ListItem(title = it.name, additional = it.info)
                    {
                        onItemClick(state.title ?: "", it.id)
                    }
                }
            }
        }
    }

}