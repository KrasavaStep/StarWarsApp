package com.example.starwarsapp.screens.details_screen.ui

import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.domain.utils.DetailModel
import com.example.domain.utils.Film
import com.example.domain.utils.StarShip
import com.example.domain.utils.Vehicle
import com.example.starwarsapp.R
import com.example.starwarsapp.ui.theme.CardBackground
import com.example.starwarsapp.ui.theme.LightYellow
import com.example.starwarsapp.util.getStringForEnum


/**
 * This is UI for Details General information
 * **/
@Composable
fun GeneralDataCard(
    data: DetailModel?
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(16.dp))
            .background(CardBackground)
            .padding(20.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Box(
                modifier = Modifier
                    .size(32.dp)
                    .clip(RoundedCornerShape(8.dp))
                    .background(LightYellow.copy(alpha = 0.1f)),
                contentAlignment = Alignment.Center
            ) {
                Icon(
                    Icons.Default.Info,
                    contentDescription = null,
                    tint = LightYellow,
                    modifier = Modifier.size(18.dp)
                )
            }
            Spacer(modifier = Modifier.width(12.dp))
            Text(
                stringResource(R.string.general_data_label),
                color = Color.White,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }

        Spacer(modifier = Modifier.height(24.dp))

        data?.info?.forEach { (k, v) ->
            when (k) {
                Film.CRAWL, StarShip.MANUFACTURER, Vehicle.MANUFACTURER -> {
                    DataColumn("${getStringForEnum(k)}: ", v)
                }
                else -> {
                    DataRow("${getStringForEnum(k)}: ", v)
                }
            }
        }
    }
}

@Composable
fun DataRow(label: String, value: String) {
    Row (modifier = Modifier.padding(bottom = 16.dp)) {
        Text(
            text = label,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(text = value, color = Color.White, fontSize = 16.sp)
    }
}

@Composable
fun DataColumn(label: String, value: String) {
    var isExpanded by remember { mutableStateOf(false) }

    Column(modifier = Modifier.padding(bottom = 16.dp)) {
        Text(
            text = label,
            color = Color.White,
            fontSize = 16.sp,
            fontWeight = FontWeight.Bold
        )
        Text(
            text = value,
            maxLines = if (isExpanded) Int.MAX_VALUE else 5,
            overflow = TextOverflow.Ellipsis,
            color = Color.White,
            fontSize = 16.sp,
            modifier = Modifier
                .clickable { isExpanded = !isExpanded }
                .animateContentSize()
        )
    }
}

