package com.example.starwarsapp.screens.home_screen.ui

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateFloat
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.togetherWith
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starwarsapp.R
import com.example.starwarsapp.ui.theme.TextGray
import kotlinx.coroutines.delay

@Preview
@Composable
fun DeathStarLoader() {
    val loadingPhrases = listOf(
        "Прогреваем гипердвигатель...",
        "Создаём звёзды...",
        "Вносим личные дела...",
        "Калибруем суперлазер...",
        "Проверяем наличие дроидов..."
    )

    var currentPhraseIndex by remember { mutableIntStateOf(0) }

    // Вращение иконки
    val infiniteTransition = rememberInfiniteTransition(label = "rotation")
    val angle by infiniteTransition.animateFloat(
        initialValue = 0f,
        targetValue = 360f,
        animationSpec = infiniteRepeatable(
            animation = tween(2500, easing = LinearEasing)
        ),
        label = "angle"
    )

    LaunchedEffect(Unit) {
        while (true) {
            delay(2000)
            currentPhraseIndex = (currentPhraseIndex + 1) % loadingPhrases.size
        }
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Image(
            painter = painterResource(id = R.drawable.death_star),
            contentDescription = null,
            colorFilter = ColorFilter.tint(TextGray),
            modifier = Modifier
                .size(80.dp)
                .rotate(angle)
        )

        Spacer(modifier = Modifier.height(32.dp))

        AnimatedContent(
            targetState = loadingPhrases[currentPhraseIndex],
            transitionSpec = {
                fadeIn(animationSpec = tween(600)) togetherWith fadeOut(animationSpec = tween(600))
            },
            label = "textFade"
        ) { targetText ->
            Text(
                text = targetText,
                color = Color(0xFFFDE047),
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(horizontal = 24.dp)
            )
        }
    }
}