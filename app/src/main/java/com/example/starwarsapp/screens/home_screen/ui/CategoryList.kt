package com.example.starwarsapp.screens.home_screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.domain.utils.CategoryName
import com.example.starwarsapp.ui.theme.Color1
import com.example.starwarsapp.ui.theme.Color2
import com.example.starwarsapp.ui.theme.Color3
import com.example.starwarsapp.ui.theme.Color4
import com.example.starwarsapp.ui.theme.Color5
import com.example.starwarsapp.ui.theme.Color6

@Composable
fun CategoryList(onCategoryClick: (tag: String) -> Unit) {
    val items = listOf(
        MenuItem(CategoryName.PEOPLE, null, null, Color1),
        MenuItem(CategoryName.PLANETS, null, null, Color2),
        MenuItem(CategoryName.STARSHIPS, null, null, Color3),
        MenuItem(CategoryName.VEHICLES, null, null, Color4),
        MenuItem(CategoryName.SPECIES, null, null, Color5),
        MenuItem(CategoryName.FILMS, null, null, Color6)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        items.forEach { item ->
            CategoryCard(item = item, onClick = {
                when (item.title) {
                    CategoryName.PEOPLE -> {
                        onCategoryClick(item.title.titleName)
                    }

                    CategoryName.PLANETS -> {
                        onCategoryClick(item.title.titleName)
                    }

                    CategoryName.STARSHIPS -> {
                        onCategoryClick(item.title.titleName)
                    }

                    CategoryName.VEHICLES -> {
                        onCategoryClick(item.title.titleName)
                    }

                    CategoryName.SPECIES -> {
                        onCategoryClick(item.title.titleName)
                    }
                    CategoryName.FILMS -> {
                        onCategoryClick(item.title.titleName)
                    }
                }
            })
        }
    }
}