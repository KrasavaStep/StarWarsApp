package com.example.starwarsapp.screens.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.text.intl.Locale
import androidx.compose.ui.text.toUpperCase
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.domain.utils.CategoryName
import com.example.starwarsapp.screens.details_screen.DetailsViewModel
import com.example.starwarsapp.screens.details_screen.ui.DetailsScreen
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
        composable(
            route = Screen.ItemList.route
        ) { backStackEntry ->
            val tag = backStackEntry.arguments?.getString("tag_category") ?: ""
            val category = CategoryName.valueOf(tag.toUpperCase(Locale.current))
            val viewModel: ItemListViewModel =
                koinViewModel(qualifier = named("list_vm")) { parametersOf(category) }
            ListScreen(
                viewModel = viewModel,
                onBackClick = { navController.popBackStack() },
                onItemClick = { detailsTag, id ->
                    navController.navigate(Screen.Details.createRoute(detailsTag, id.id))
                }
            )
        }


        // Details screen
        composable(
            route = Screen.Details.route,
            arguments = listOf(
                navArgument("details_tag") { type = NavType.StringType },
                navArgument("details_id") { type = NavType.IntType }
            )
        ) { backStackEntry ->
            val tag = backStackEntry.arguments?.getString("details_tag") ?: ""
            val category = CategoryName.valueOf(tag.toUpperCase(Locale.current))
            val id = backStackEntry.arguments?.getInt("details_id") ?: 0
            val viewModel: DetailsViewModel =
                koinViewModel(qualifier = named("details_vm")) { parametersOf(category, id) }
            DetailsScreen(viewModel) { navController.popBackStack() }
        }
    }
}