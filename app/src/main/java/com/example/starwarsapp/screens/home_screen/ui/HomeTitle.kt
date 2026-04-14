package com.example.starwarsapp.screens.home_screen.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.starwarsapp.ui.theme.LightYellow
import com.example.starwarsapp.ui.theme.TextGray

@Composable
fun HomeTitle(
    onUpdateClick: () -> Unit
) {
    Row(
        horizontalArrangement = Arrangement.Absolute.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .background(Color.Black)
                .padding(16.dp)
        ) {
            Text(
                text = "Explore the Galaxy",
                color = LightYellow,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = (-0.5).sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Select a category to begin your journey.",
                color = TextGray,
                fontSize = 18.sp,
                fontWeight = FontWeight.Normal
            )
        }
        Icon(
            Icons.Default.Refresh,
            contentDescription = null,
            tint = LightYellow,
            modifier = Modifier.size(48.dp).background(Color.Black).clickable {
                onUpdateClick()
            }.padding(horizontal = 8.dp)
        )
    }
}