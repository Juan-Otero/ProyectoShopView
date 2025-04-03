package com.example.proyectopoli.screens.fragments.content

// Importación de librerias necesarias
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowCircleLeft
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// Vista general del fragmento y fijación de la barra superior
@Composable
fun ShopViewScreen() {
    Scaffold(
        topBar = { TopBar() } // Barra superior fija
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues) // Establece los límites de la barra para no sobreponer el contenido
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            // Espacios para ajustar la informacion del producto (Imagen, Descripción, Acciones)
            Spacer(modifier = Modifier.height(20.dp))
            ProductImage()
            Spacer(modifier = Modifier.height(20.dp))
            ProductInfo()
            Spacer(modifier = Modifier.height(20.dp))
            ActionButtons()
            Spacer(modifier = Modifier.height(15.dp))
            VisitLink()
        }
    }
}

// Componente de la barra superior
@OptIn(ExperimentalMaterial3Api::class) // Utiliza la API experimental Material3 para crear la barra
@Composable
fun TopBar() {
    TopAppBar(
        title = { Text("ShopView", fontWeight = FontWeight.Bold, color = Color.White) },
        navigationIcon = {
            IconButton(onClick = { /* Acción de retroceso */ }) {
                Icon(Icons.Default.ArrowCircleLeft, contentDescription = "Retroceder", tint = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(0xFF2A3B66))
    )
}

// Visualizar el fragment con el metodo Preview
@Preview(showBackground = true)
@Composable
fun PreviewShopView() {
    ShopViewScreen()
}