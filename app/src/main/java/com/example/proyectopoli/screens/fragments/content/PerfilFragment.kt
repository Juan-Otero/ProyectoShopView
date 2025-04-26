package com.example.proyectopoli.screens.fragments.content

import android.content.Context
import android.widget.Toast
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectopoli.model.UserProfile

@Composable
fun PerfilFragment(navController: NavController) {

    val context = LocalContext.current
    val prefs = context.getSharedPreferences("usuario", Context.MODE_PRIVATE)

    var userProfile by remember {
        mutableStateOf(
            UserProfile(
                userName = prefs.getString("nombres", "") ?: "",
                userLastName = prefs.getString("apellidos", "") ?: "",
                userPhone = prefs.getString("telefono", "") ?: "",
                userAddress = prefs.getString("direccion", "") ?: "",
                userEmail = prefs.getString("email", "") ?: ""
            )
        )
    }

    // Contenedor de todos los elementos del fragment
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(0.dp),
        contentAlignment = Alignment.TopCenter
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {

            // Barra superior de la pantalla
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(60.dp)
                    .background(Color(0xFF2A3B65)),
                contentAlignment = Alignment.CenterStart
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier.padding(start = 16.dp)
                ) {

                    // Botón para retroceder
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Back",
                        tint = Color.White,
                        modifier = Modifier
                            .size(26.dp)
                            .clickable { navController.popBackStack() }
                    )

                    // Texto ShopView con estrella
                    Spacer(modifier = Modifier.width(90.dp))
                    Icon(
                        imageVector = Icons.Default.Star,
                        contentDescription = "Star",
                        tint = Color.White,
                        modifier = Modifier.size(24.dp)
                    )
                    Spacer(modifier = Modifier.width(6.dp))
                    Text(
                        text = "ShopView",
                        color = Color.White,
                        fontSize = 22.sp,
                        fontWeight = FontWeight.Medium
                    )
                }
            }

            Spacer(modifier = Modifier.height(20.dp))

            // Columna que contiene el título de la pantalla y los campos de texto
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .clip(RoundedCornerShape(16.dp))
                    .background(Color(0xFFFDFDFD))
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                // Titulo
                Text(
                    text = "Datos Personales",
                    fontSize = 28.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black
                )

                Spacer(modifier = Modifier.height(30.dp))


                // Campos de texto de los datos del usuario
                CustomProfileTextField(
                    value = userProfile.userName,
                    onValueChange = { userProfile = userProfile.copy(userName = it)},
                    placeholder = "Nombres"
                )
                Spacer(modifier = Modifier.height(15.dp))

                CustomProfileTextField(
                    value = userProfile.userLastName,
                    onValueChange = { userProfile = userProfile.copy(userLastName = it)},
                    placeholder = "Apellidos"
                )
                Spacer(modifier = Modifier.height(15.dp))

                CustomProfileTextField(
                    value = userProfile.userPhone,
                    onValueChange = { userProfile = userProfile.copy(userPhone = it)},
                    placeholder = "Teléfono"
                )
                Spacer(modifier = Modifier.height(15.dp))

                CustomProfileTextField(
                    value = userProfile.userAddress,
                    onValueChange = { userProfile = userProfile.copy(userAddress = it)},
                    placeholder = "Dirección"
                )
                Spacer(modifier = Modifier.height(15.dp))

                CustomProfileTextField(
                    value = userProfile.userEmail,
                    onValueChange = { userProfile = userProfile.copy(userEmail = it)},
                    placeholder = "Email"
                )

                Spacer(modifier = Modifier.height(50.dp))


                // Botón para guardar los cambios realizados
                Button(
                    onClick = {
                        val editor = prefs.edit()
                        editor.putString("nombres", userProfile.userName)
                        editor.putString("apellidos", userProfile.userLastName)
                        editor.putString("telefono", userProfile.userPhone)
                        editor.putString("direccion", userProfile.userAddress)
                        editor.putString("email", userProfile.userEmail)
                        editor.apply()

                        Toast.makeText(context, "Datos guardados", Toast.LENGTH_SHORT).show()
                    },
                    shape = RoundedCornerShape(50),
                    colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF3B68B2)),
                    modifier = Modifier
                        .width(130.dp)
                        .height(50.dp)
                ) {
                    Text(
                        "Guardar",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White
                    )
                }
            }
        }
    }
}

// Diseños personalizado para los campos de texto
@Composable
fun CustomProfileTextField(value: String, onValueChange: (String) -> Unit, placeholder: String) {

    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = { Text(placeholder, color = Color.Gray) },
        singleLine = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clip(RoundedCornerShape(10.dp)),

        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color(0xFFEFEFEF),
            unfocusedContainerColor = Color(0xFFEFEFEF),
            cursorColor = Color.Black,
            focusedTextColor = Color.Black,
            unfocusedTextColor = Color.Black
        )
    )
}
