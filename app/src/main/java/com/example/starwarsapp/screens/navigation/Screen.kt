package com.example.starwarsapp.screens.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object ItemList : Screen("items/{tag_category}") {
        fun createRoute(tag: String) = "items/$tag"
    }
    object Details : Screen("details/{tag_item}") {
        fun createRoute(tag: String) = "details/$tag"
    }
}