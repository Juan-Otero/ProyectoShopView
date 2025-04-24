package com.example.proyectopoli.screens.fragments.content

import android.content.Intent
import android.inputmethodservice.Keyboard.Row
import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopoli.R
import com.example.proyectopoli.ui.theme.BlackButton

@Composable
@Preview
fun WebFragment() {
    Scaffold(
        topBar = { TopBar() } // Reutilizas tu barra superior
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(30.dp))

            // Título
            Text(
                text = "Navegador\nWeb",
                lineHeight = 40.sp,
                fontWeight = FontWeight.SemiBold,
                fontSize = 34.sp,
                textAlign = TextAlign.Center,
                color = BlackButton
            )

            Spacer(modifier = Modifier.height(40.dp))

            // Campo de entrada de URL
            var url by remember { mutableStateOf("") }
            val context = LocalContext.current



            OutlinedTextField(
                value = url,
                onValueChange = { url = it },
                placeholder = { Text("Ingrese la URL del sitio", color = Color.Gray, fontSize = 20.sp) },
                singleLine = true,
                shape = RoundedCornerShape(50),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 30.dp)
                    .height(60.dp),

                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color.White,
                    unfocusedContainerColor = Color.White,
                    focusedTextColor = Color.Black,
                    unfocusedTextColor = Color.Black,
                    cursorColor = Color.Black),

                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Go
                ),

                keyboardActions = KeyboardActions(

                    onGo = {
                        val fixedUrl = if (!url.startsWith("http://") && !url.startsWith("https://")) {
                            "http://$url"
                        }
                        else url
                        val intent = Intent(Intent.ACTION_VIEW, Uri.parse(fixedUrl))
                        context.startActivity(intent)
                    }
                ),

                trailingIcon = {
                    if (url.isNotEmpty()) {
                        IconButton(onClick = { url = "" }) {
                            Icon(Icons.Default.Clear, contentDescription = "Borrar texto")
                        }
                    }
                },
            )

            Spacer(modifier = Modifier.height(180.dp))

            // Logo centrado
            Image(
                painter = painterResource(id = R.drawable.logo_shopview),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(50))
            )

            Spacer(modifier = Modifier.height(30.dp))

            // Texto explicativo
            Text(
                text = "En esta sección puede ingresar al\nsitio web que desee ingresando\nla URL en el buscador",
                fontSize = 24.sp,
                fontWeight = FontWeight.Light,
                textAlign = TextAlign.Center,
                lineHeight = 32.sp,
                color = BlackButton,
                modifier = Modifier
                    .padding(16.dp)
            )
        }
    }
}