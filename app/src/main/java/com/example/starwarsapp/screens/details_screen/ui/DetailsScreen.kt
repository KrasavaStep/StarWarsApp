package com.example.starwarsapp.screens.details_screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.starwarsapp.R
import com.example.starwarsapp.screens.details_screen.DetailsViewModel
import com.example.starwarsapp.screens.home_screen.ui.DeathStarLoader

@Composable
fun DetailsScreen(
    viewModel: DetailsViewModel,
    onBackClick: () -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    if (state.isLoading) {
        DeathStarLoader()
    }
    else {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Black)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            item {
                DetailsTitle(state.data?.name ?: "") {
                    onBackClick()
                }
            }
            item {
                GeneralDataCard(state.data)
            }

            state.data?.extraLists?.forEach { relatedData ->
                item { SectionHeader(relatedData.title) }
                if (relatedData.items.isEmpty()) {
                    item {
                        AdditionalItem(stringResource(R.string.no_info_label))
                    }
                }
                else {
                    items(relatedData.items) { itemName ->
                        AdditionalItem(itemName)
                    }
                }
            }
        }
    }
}