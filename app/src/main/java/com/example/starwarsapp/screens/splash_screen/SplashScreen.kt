package com.example.starwarsapp.screens.splash_screen

import androidx.compose.animation.core.LinearOutSlowInEasing
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.starwarsapp.R
import com.example.starwarsapp.ui.theme.LightYellow
import kotlinx.coroutines.delay

@Composable
fun StarWarsSplashScreen(onTimeout: () -> Unit) {
    var startAnimation by remember { mutableStateOf(false) }

    val scale by animateFloatAsState(
        targetValue = if (startAnimation) 0f else 4f,
        animationSpec = tween(durationMillis = 3000, easing = LinearOutSlowInEasing),
        label = "scale"
    )

    val alpha by animateFloatAsState(
        targetValue = if (startAnimation) 0f else 1f,
        animationSpec = tween(durationMillis = 3000),
        label = "alpha"
    )

    LaunchedEffect(Unit) {
        startAnimation = true
        delay(3200)
        onTimeout()
    }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black),
        contentAlignment = Alignment.Center
    ) {
        StarryBackground()

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .graphicsLayer(
                    scaleX = scale,
                    scaleY = scale,
                    alpha = alpha
                )
        ) {
            Text(
                text = stringResource(R.string.splash_header_1),
                color = LightYellow,
                fontSize = 80.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 8.sp
            )
            Text(
                text = stringResource(R.string.splash_header_2),
                color = LightYellow,
                fontSize = 80.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 8.sp
            )
            Text(
                text = stringResource(R.string.splash_subheader),
                color = Color.White,
                fontSize = 14.sp,
                fontWeight = FontWeight.Light,
                letterSpacing = 4.sp
            )
        }
    }
}