package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
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
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
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
                    .clip(RoundedCornerShape(100.dp))
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Titulo de la interfaz
            Text("Registro", fontSize = 28.sp, fontWeight = FontWeight.Bold, color = Color.White)

            Spacer(modifier = Modifier.height(25.dp))

            // Campos de texto para el nombre
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                CustomTextField(placeholder = "Nombres", false,modifier = Modifier.weight(1f))
                Spacer(modifier = Modifier.width(10.dp))
                CustomTextField(placeholder = "Apellidos", false, modifier = Modifier.weight(1f))
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Campo de texto del telefono
            CustomTextField(placeholder = "Teléfono", false)
            Spacer(modifier = Modifier.height(20.dp))

            // Campo de texto de la dirección
            CustomTextField(placeholder = "Dirección", false)
            Spacer(modifier = Modifier.height(20.dp))

            // Campo de texto para el correo electrónico
            CustomTextField(placeholder = "Email", false)
            Spacer(modifier = Modifier.height(20.dp))

            // Campo de texto para la contraseña
            CustomTextField(placeholder = "Contraseña", true)
            Spacer(modifier = Modifier.height(25.dp))


            // Botón para crear la cuenta
            Button(
                onClick = { /* Acción de registro */ },
                colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                modifier = Modifier.width(160.dp)
            ) {
                Text("Crear cuenta", color = Color.White, fontSize = 17.sp)
            }

            Spacer(modifier = Modifier.height(30.dp))

            // Cuadro de texto para iniciar sesión
            Row {
                Text(
                    "¿Ya tienes una cuenta?",
                    color = Color.White,
                    fontSize = 16.sp)

                Spacer(modifier = Modifier.width(8.dp))

                Text(
                    "Inicia Sesión",
                    color = BlueButton,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,

                    modifier = Modifier.clickable { /* Navegar al login */ }
                )
            }
        }
    }
}

// Componente para crear y personalizar los campos de texto
@Composable
fun CustomTextField(placeholder: String, isPassword: Boolean, modifier: Modifier = Modifier) {
    var text by remember { mutableStateOf("") }
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    // Parametros de texto de los campos
    TextField(
        value = text,
        onValueChange = { text = it },
        placeholder = { Text(placeholder, color = Color.Gray) },
        singleLine = true,
        visualTransformation = if (isPassword && !passwordVisible) PasswordVisualTransformation() else VisualTransformation.None,
        modifier = modifier
            .fillMaxWidth()
            .height(60.dp)
            .clip(RoundedCornerShape(20.dp))
            .padding(2.dp),

        // Parametros de color del texto y el fondo de los campos
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFDDDDDD),
            unfocusedContainerColor = Color(0xFFDDDDDD),
            cursorColor = BlackButton,
            focusedTextColor = BlackButton,
            unfocusedTextColor = BlackButton
        ),

        // Condicional para ocultar/mostrar la contraseña solo en dicho campo
        trailingIcon = {
            if (isPassword) {
                IconButton(onClick = { passwordVisible = !passwordVisible }) {
                    Icon(
                        imageVector = if (passwordVisible) Icons.Default.Visibility else Icons.Default.VisibilityOff,
                        contentDescription = if (passwordVisible) "Ocultar contraseña" else "Mostrar contraseña",
                        tint = BlueButton
                    )
                }
            }
        }
    )
}