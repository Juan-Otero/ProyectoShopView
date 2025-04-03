package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopoli.R

@Composable
@Preview
fun RegistroFragment() {

    // Caja que contiene todos los elementos de la interfaz
    Box(
        modifier = Modifier
            .fillMaxSize()

            // Fondo degradado y capa para oscurecer
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFF2A3B65),
                        Color(0xFFD1F8EF)
                    )
                )
            )
            .background(Color(0xFF000000).copy(alpha = 0.7f)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .padding(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            // Logo del catalogo
            Image(
                painter = painterResource(id = R.drawable.logo_shopview),
                contentDescription = "Logo",
                modifier = Modifier.size(160.dp)
                    .clip(RoundedCornerShape(60.dp))
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Titulo de la interfaz
            Text("Registro", fontSize = 35.sp, fontWeight = FontWeight.Bold, color = Color.White)

            Spacer(modifier = Modifier.height(20.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ){}
        }
    }
}