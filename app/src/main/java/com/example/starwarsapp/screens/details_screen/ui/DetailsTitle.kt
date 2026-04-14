package com.example.starwarsapp.screens.details_screen.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starwarsapp.ui.theme.LightYellow

/**
 * This is UI for Details Screen top bar
 * **/

@Composable
fun DetailsTitle(
    title: String,
    onBackClick: () -> Unit
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack,
            contentDescription = null,
            tint = LightYellow,
            modifier = Modifier.size(32.dp).clickable { onBackClick() }.padding(horizontal = 6.dp)
        )
        Text(
            text = title,
            color = LightYellow,
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold
        )
    }
}