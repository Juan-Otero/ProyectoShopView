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

// Componente reutilizable para el carrusel de imagenes que se muestra en el Fragment Item
@Composable
fun ImageCarousel(images: List<Int>, modifier: Modifier = Modifier) {
    var currentIndex by remember { mutableStateOf(0) }

    Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = modifier) {
        Box(contentAlignment = Alignment.Center) {

            // Imagen inicial que se muestra en pantalla
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

                // Icono para desplazarse a la anterior imagen
                IconButton(
                    onClick = {

                        // Condicional para verificar si hay una imagen antes en la lista que la almacena o no
                        currentIndex = if (currentIndex == 0) images.lastIndex else currentIndex - 1
                    }
                ) {
                    Icon(Icons.Default.ArrowBack, contentDescription = "Anterior", tint = Color(0xFF1976D2))
                }

                // Icono para desplazarle a la siguiente imagen
                IconButton(
                    onClick = {

                        // Acción de incrementar el Índice de la lista de imagenes para desplazarle a la siguiente
                        currentIndex = (currentIndex + 1) % images.size
                    }
                ) {
                    Icon(Icons.Default.ArrowForward, contentDescription = "Siguiente", tint = Color(0xFF1976D2))
                }
            }
        }
    }
}
