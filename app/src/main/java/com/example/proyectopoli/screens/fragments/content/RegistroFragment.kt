package com.example.proyectopoli.screens.fragments.content

import android.content.Context
import android.widget.Toast
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
import androidx.compose.runtime.saveable.rememberSaveable
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
import com.example.proyectopoli.ui.theme.BlackButton
import com.example.proyectopoli.ui.theme.BlueButton

@Composable
fun RegistroFragment(navController: NavController) {
    val context = LocalContext.current

    var nombres by remember { mutableStateOf("") }
    var apellidos by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
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
                modifier = Modifier.size(160.dp).clip(RoundedCornerShape(100.dp))
            )

            Spacer(modifier = Modifier.height(30.dp))
            Text("Registro", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)
            Spacer(modifier = Modifier.height(25.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomTextField("Nombres", false, nombres, { nombres = it }, Modifier.weight(1f))
                Spacer(modifier = Modifier.width(10.dp))
                CustomTextField("Apellidos", false, apellidos, { apellidos = it }, Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField("Teléfono", false, telefono, { telefono = it })
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField("Dirección", false, direccion, { direccion = it })
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField("Email", false, email, { email = it })
            Spacer(modifier = Modifier.height(20.dp))
            CustomTextField("Contraseña", true, password, { password = it })

            Spacer(modifier = Modifier.height(15.dp))

            errorMessage?.let {
                Text(it, color = Color.Red, fontSize = 14.sp)
                Spacer(modifier = Modifier.height(10.dp))
            }

            Button(
                onClick = {
                    if (nombres.isBlank() || apellidos.isBlank() || telefono.isBlank()
                        || direccion.isBlank() || email.isBlank() || password.isBlank()
                    ) {
                        errorMessage = "Todos los campos son obligatorios."
                    } else {
                        errorMessage = null
                        val prefs = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)
                        prefs.edit()
                            .putString("nombres", nombres)
                            .putString("apellidos", apellidos)
                            .putString("telefono", telefono)
                            .putString("direccion", direccion)
                            .putString("email", email)
                            .putString("password", password)
                            .apply()

                        Toast.makeText(context, "¡Registro exitoso!", Toast.LENGTH_SHORT).show()
                        navController.navigate("login")
                    }
                },
                colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                modifier = Modifier.width(160.dp)
            ) {
                Text("Crear cuenta", color = Color.White, fontSize = 17.sp)
            }

            Spacer(modifier = Modifier.height(30.dp))

            Row {
                Text("¿Ya tienes una cuenta?", color = Color.White, fontSize = 16.sp)
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    "Inicia Sesión",
                    color = BlueButton,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    modifier = Modifier.clickable { navController.navigate("login") }
                )
            }
        }
    }
}

@Composable
fun CustomTextField(
    placeholder: String,
    isPassword: Boolean,
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder, color = Color.Gray) },
        singleLine = true,
        visualTransformation = if (isPassword && !passwordVisible)
            PasswordVisualTransformation() else VisualTransformation.None,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(20.dp))
            .padding(2.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFDDDDDD),
            unfocusedContainerColor = Color(0xFFDDDDDD),
            cursorColor = BlackButton,
            focusedTextColor = BlackButton,
            unfocusedTextColor = BlackButton
        ),
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = null,
                        tint = BlueButton
                    )
                }
            }
        }
    )
}
