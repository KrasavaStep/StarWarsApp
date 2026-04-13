package com.example.starwarsapp.screens.home_screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.starwarsapp.screens.home_screen.HomeScreenIntent
import com.example.starwarsapp.screens.home_screen.HomeScreenViewModel
import com.example.starwarsapp.ui.theme.LightYellow

@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
    onCategoryClick: (tag: String) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        when {
            state.isLoading -> {
                DeathStarLoader()
            }

            state.error != null -> {
                ErrorView {
                    viewModel.handleIntent(HomeScreenIntent.RefreshData)
                }
            }

            state.data != null -> {
                Column(
                    modifier = Modifier.fillMaxSize()
                ) {
                    HomeTitle()
                    CategoryList() { tag ->
                        onCategoryClick(tag)
                    }
                }
            }

            else -> {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp)
                        .height(56.dp)
                        .clip(RoundedCornerShape(16.dp))
                        .background(LightYellow)
                        .clickable { viewModel.handleIntent(HomeScreenIntent.LoadAllData) },
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = "Load Star Wars data",
                        color = Color.Black,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.ExtraBold,
                        letterSpacing = 1.sp
                    )
                }
            }
        }

    }
}


