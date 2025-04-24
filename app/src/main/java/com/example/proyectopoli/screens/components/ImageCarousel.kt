package com.example.proyectopoli.screens.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowForward
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun ImageCarousel(images: List<Int>, modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Box(contentAlignment = Alignment.Center) {
            Image(
                painter = painterResource(id = images[currentIndex]),
                contentDescription = "Imagen del producto",
                modifier = Modifier
                    .size(220.dp)
                    .clip(RoundedCornerShape(40.dp)),
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                IconButton(
                    onClick = {
                        currentIndex = if (currentIndex == 0) images.lastIndex else currentIndex - 1
                    }
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Anterior", tint = Color(0xFF1976D2))
                }

                IconButton(
                    onClick = {
                        currentIndex = (currentIndex + 1) % images.size
                    }
                ) {
                    Icon(Icons.Default.ArrowForward, contentDescription = "Siguiente", tint = Color(0xFF1976D2))
                }
            }
        }
    }
}
