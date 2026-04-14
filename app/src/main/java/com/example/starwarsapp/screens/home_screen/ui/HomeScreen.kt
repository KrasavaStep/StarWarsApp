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
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Snackbar
import androidx.compose.material3.SnackbarDuration
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.SnackbarResult
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.starwarsapp.R
import com.example.starwarsapp.screens.home_screen.HomeScreenIntent
import com.example.starwarsapp.screens.home_screen.HomeScreenViewModel
import com.example.starwarsapp.ui.theme.CardBackground
import com.example.starwarsapp.ui.theme.LightYellow


@Composable
fun HomeScreen(
    viewModel: HomeScreenViewModel,
    onCategoryClick: (tag: String) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    val state by viewModel.state.collectAsStateWithLifecycle()
    val context = LocalContext.current

    /**
     * Check for offline exception
     * **/

    LaunchedEffect(state.isOffline) {
        if (state.isOffline) {
            val result = snackbarHostState.showSnackbar(
                message = context.getString(R.string.no_internet_connection),
                actionLabel = context.getString(R.string.try_again_label),
                duration = SnackbarDuration.Indefinite
            )

            if (result == SnackbarResult.ActionPerformed) {
                viewModel.handleIntent(HomeScreenIntent.RefreshData)
            }
        }
        else {
            snackbarHostState.currentSnackbarData?.dismiss()
        }
    }

    /**
     * Check for other exceptions
     * **/

    LaunchedEffect(state.error) {
        if (state.error != null) {
            val result = snackbarHostState.showSnackbar(
                message = context.getString(R.string.smth_went_wrong_label),
                actionLabel = context.getString(R.string.try_again_label),
                duration = SnackbarDuration.Long
            )

            if (result == SnackbarResult.ActionPerformed) {
                viewModel.handleIntent(HomeScreenIntent.RefreshData)
            }

            viewModel.handleIntent(HomeScreenIntent.ClearError)
        }
    }



    Scaffold(
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState) { data ->
                Snackbar(
                    snackbarData = data,
                    containerColor = CardBackground,
                    contentColor = Color.White,
                    actionColor = LightYellow
                )
            }
        }
    ) { paddingValues ->
        Box(modifier = Modifier.fillMaxSize().padding(paddingValues), contentAlignment = Alignment.Center) {
            when {
                state.isLoading -> {
                    DeathStarLoader()
                }

                state.data != null -> {
                    Column(
                        modifier = Modifier.fillMaxSize()
                    ) {
                        HomeTitle() {
                            viewModel.handleIntent(HomeScreenIntent.RefreshData)
                        }
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
                            text = stringResource(R.string.loader_btn_text),
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
}


