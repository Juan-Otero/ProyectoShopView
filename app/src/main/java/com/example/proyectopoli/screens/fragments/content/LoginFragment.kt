package com.example.proyectopoli.screens.fragments.content

import android.content.Context
import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectopoli.R
import com.example.proyectopoli.ui.theme.BlueButton

@Composable
fun LoginFragment(navController: NavController) {
    val context = LocalContext.current

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var errorMessage by remember { mutableStateOf<String?>(null) }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(
                brush = Brush.verticalGradient(
                    listOf(Color(0xFF2A3B65), Color(0xFFD1F8EF))
                )
            )
            .background(Color.Black.copy(alpha = 0.7f)),
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

            CustomTextField(
                placeholder = "Email",
                isPassword = false,
                value = email,
                onValueChange = { email = it }
            )
            Spacer(modifier = Modifier.height(20.dp))

            CustomTextField(
                placeholder = "Contraseña",
                isPassword = true,
                value = password,
                onValueChange = { password = it }
            )

            Spacer(modifier = Modifier.height(20.dp))

            errorMessage?.let {
                Text(it, color = Color.Red, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(10.dp))
            }

            Button(
                onClick = {
                    if (email.isBlank() || password.isBlank()) {
                        errorMessage = "Por favor ingresa tu email y contraseña"
                        return@Button
                    }

                    val prefs = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)
                    val savedEmail = prefs.getString("email", null)
                    val savedPassword = prefs.getString("password", null)

                    if (email == savedEmail && password == savedPassword) {
                        Toast.makeText(context, "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show()
                        navController.navigate("home")
                    } else {
                        errorMessage = "Credenciales incorrectas"
                    }
                },
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
                    modifier = Modifier.clickable {
                        navController.navigate("registro")
                    }
                )
            }
        }
    }
}
