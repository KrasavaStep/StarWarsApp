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

@Composable
fun CategoryList(onCategoryClick: (tag: String) -> Unit) {
    val items = listOf(
        MenuItem(CategoryName.PEOPLE, null, null, Color(0xFF2D5AF6)),
        MenuItem(CategoryName.PLANETS, null, null, Color(0xFF00AD45)),
        MenuItem(CategoryName.STARSHIPS, null, null, Color(0xFF9520FF)),
        MenuItem(CategoryName.VEHICLES, null, null, Color(0xFFFF5215)),
        MenuItem(CategoryName.SPECIES, null, null, Color(0xFFFF001E)),
        MenuItem(CategoryName.FILMS, null, null, Color(0xFFF35A69))
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