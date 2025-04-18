package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopoli.R
import com.example.proyectopoli.ui.theme.BlackButton
import com.example.proyectopoli.ui.theme.BlueButton

@Composable
@Preview
fun LoginFragment() {
    Box(
        modifier = Modifier
            .fillMaxSize()
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
                .padding(14.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.logo_shopview),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(160.dp)
                    .clip(RoundedCornerShape(100.dp))
            )

            Spacer(modifier = Modifier.height(30.dp))

            Text("Login", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)

            Spacer(modifier = Modifier.height(30.dp))

            CustomTextField(placeholder = "Email", isPassword = false)
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField(placeholder = "Contraseña", isPassword = true)
            Spacer(modifier = Modifier.height(25.dp))

            Button(
                onClick = { /* Acción de login */ },
                colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                modifier = Modifier.width(200.dp)
            ) {
                Text("Iniciar sesión", color = Color.White, fontSize = 17.sp)
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row {
                Text("¿No tienes una cuenta?", color = Color.White, fontSize = 16.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Regístrate",
                    color = BlueButton,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.clickable { /* Navegar a registro */ }
                )
            }
        }
    }
}
