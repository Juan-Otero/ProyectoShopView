package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import androidx.navigation.NavController
import com.example.proyectopoli.R
import com.example.proyectopoli.ui.theme.BlueButton

@Composable
fun InicioFragment(navController: NavController) {

    // Caja que contiene todos los elementos de la interfaz
    Box(
        modifier = Modifier
            .fillMaxSize()

            // Fondo degradado y capa para oscurecer
            .background(
                brush = Brush.verticalGradient(
                    listOf(
                        Color(0xFF2A3B65),
                        Color(0xFF578FCA)
                    )
                )
            )
            .background(Color(0xFF000000).copy(alpha = 0.2f)),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(6.dp)
                .padding(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            // Titulo de bienvenida
            Text("|| BIENVENIDO ||", fontSize = 40.sp, fontWeight = FontWeight.ExtraBold, color = Color.White)

            Spacer(modifier = Modifier.height(70.dp))

            // Logo de la aplicación
            Image(
                painter = painterResource(id = R.drawable.logo_shopview),
                contentDescription = "Logo",
                modifier = Modifier.size(300.dp)
                    .clip(RoundedCornerShape(150.dp))
            )

            Spacer(modifier = Modifier.height(120.dp))

            // Botón para iniciar sesión
            Button(
                onClick = { navController.navigate("login") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp)
            ) {
                Text("Iniciar Sesión", color = BlueButton, fontSize = 24.sp, fontWeight = FontWeight.Normal)
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Botón para registrarse en la aplicación
            Button(
                onClick = { navController.navigate("registro") },
                colors = ButtonDefaults.buttonColors(containerColor = Color.White),
                modifier = Modifier
                    .width(300.dp)
                    .height(50.dp)
            ) {
                Text("Registrarse", color = BlueButton, fontSize = 24.sp, fontWeight = FontWeight.Normal)
            }

        }
    }
}