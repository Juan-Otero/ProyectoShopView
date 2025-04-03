package com.example.proyectopoli.screens.fragments.content

// Importación de librerias necesarias
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIos
import androidx.compose.material.icons.filled.ArrowCircleLeft
import androidx.compose.material.icons.filled.ArrowForwardIos
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopoli.R

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

/* SECCIÓN DE PRODUCTO */
// Componente de las imagenes y videos del producto con las flechas para desplazarlas
@Composable
fun ProductImage() {

    // Componente que encierra la imagen del producto y los botones
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 16.dp)
    ) {
        // Botón para desplazar a la izquierda
        IconButton(
            onClick = { /* Acción para ver imagen anterior */ },
            modifier = Modifier.align(Alignment.CenterStart)
        ) {
            Icon(Icons.Default.ArrowBackIos, contentDescription = "Anterior", tint = Color(0xFF5DADE2))
        }

        // Imagen del producto
        Image(
            painter = painterResource(id = R.drawable.ic_launcher_background), // Reemplaza con tu imagen
            contentDescription = "Imagen del producto",
            modifier = Modifier
                .size(200.dp)
                .clip(RoundedCornerShape(20.dp))
                .background(Color(0xFFF0F0F0)),
            contentScale = ContentScale.Crop
        )

        // Botón para desplazarse a la derecha
        IconButton(
            onClick = { /* Acción para ver siguiente imagen */ },
            modifier = Modifier.align(Alignment.CenterEnd)
        ) {
            Icon(Icons.Default.ArrowForwardIos, contentDescription = "Siguiente", tint = Color(0xFF5DADE2))
        }
    }
}

// Componente de informacion detallada del producto
@Composable
fun ProductInfo() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text("Nombre del Producto", fontWeight = FontWeight.Bold, fontSize = 20.sp)
        Text("Descripción del Producto", fontSize = 16.sp, color = Color.Gray)
        Spacer(modifier = Modifier.height(10.dp))
        Text("$200.000", fontWeight = FontWeight.Bold, fontSize = 24.sp)
    }
}


// Visualizar el fragment con el metodo Preview
@Preview(showBackground = true)
@Composable
fun PreviewShopView() {
    ShopViewScreen()
}