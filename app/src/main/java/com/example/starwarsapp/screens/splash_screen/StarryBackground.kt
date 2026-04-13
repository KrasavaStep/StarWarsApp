package com.example.starwarsapp.screens.splash_screen

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import java.util.Random

@Composable
fun StarryBackground(modifier: Modifier = Modifier) {
    Canvas(modifier = modifier.fillMaxSize()) {
        val random = Random(42)
        repeat(200) {
            drawCircle(
                color = Color.White.copy(alpha = random.nextFloat()),
                radius = random.nextFloat() * 3f,
                center = Offset(
                    x = random.nextFloat() * size.width,
                    y = random.nextFloat() * size.height
                )
            )
        }
    }
}