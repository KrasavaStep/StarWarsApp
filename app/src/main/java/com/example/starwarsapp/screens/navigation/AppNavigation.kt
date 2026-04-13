package com.example.starwarsapp.screens.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.domain.utils.CategoryName
import com.example.starwarsapp.screens.home_screen.HomeScreenViewModel
import com.example.starwarsapp.screens.home_screen.ui.HomeScreen
import com.example.starwarsapp.screens.list_screen.ItemListViewModel
import com.example.starwarsapp.screens.list_screen.ui.ListScreen
import org.koin.androidx.compose.koinViewModel
import org.koin.core.parameter.parametersOf
import org.koin.core.qualifier.named

@Composable
fun AppNavigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Screen.Home.route
    ) {
        //Home screen
        composable(Screen.Home.route) {
            val viewModel: HomeScreenViewModel = koinViewModel(qualifier = named("home_vm"))
            HomeScreen(viewModel = viewModel, onCategoryClick = { tag ->
                navController.navigate(Screen.ItemList.createRoute(tag))
            })
        }

        // List screen
        composable(Screen.ItemList.route) { backStackEntry ->
            val tag = backStackEntry.arguments?.getString("tag_category") ?: ""
            Log.e("ROUTE", tag)
            val category = CategoryName.valueOf(tag.toUpperCase(Locale.current))
            val viewModel: ItemListViewModel = koinViewModel(qualifier = named("list_vm")) { parametersOf(category) }
            ListScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onItemClick = { detailsTag ->
                    navController.navigate(Screen.Details.createRoute(detailsTag))
                }
            )
        }

        /*
        // Details screen
        composable(Screen.Details.route) { backStackEntry ->
            val personName = backStackEntry.arguments?.getString("personName") ?: ""
            PersonDetailScreen(name = personName)
        }*/
    }
}