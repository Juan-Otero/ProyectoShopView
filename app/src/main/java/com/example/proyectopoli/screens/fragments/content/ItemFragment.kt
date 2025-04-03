package com.example.proyectopoli.screens.fragments.content

// Importación de librerias necesarias
import android.text.style.BackgroundColorSpan
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopoli.R


// Vista general del fragmento y fijación de la barra superior
@Composable
fun ShopViewScreen() {
    Scaffold(
        topBar = { TopBar() } // Fijar la barra superior
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {

            // Espacios para ajustar la informacion del producto (Imagen, Descripción, Acciones)
            Spacer(modifier = Modifier.height(0.dp))
            ProductImage()
            Spacer(modifier = Modifier.height(20.dp))
            ProductInfo()
            Spacer(modifier = Modifier.height(30.dp))
            ActionButtons()
            Spacer(modifier = Modifier.height(100.dp))
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
                .size(230.dp)
                .clip(RoundedCornerShape(40.dp))
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
        Text("Item XXXX", fontWeight = FontWeight.Bold, fontSize = 26.sp)
        Text("Descripción del Producto", fontSize = 20.sp, color = Color.Gray, textAlign = TextAlign.Center)
        Spacer(modifier = Modifier.height(30.dp))
        Text("$200.000", fontWeight = FontWeight.Bold, fontSize = 30.sp)
    }
}


// Botones de agregar al carrito y comprar
@Composable
fun ActionButtons() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        // Botón para agregar el producto al carrito
        Button(
            onClick = { /* Acción agregar al carrito */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color.Black),
            modifier = Modifier.fillMaxWidth(0.4f)
        ) {
            Text("Agregar a carrito", color = Color.White)
        }

        Spacer(modifier = Modifier.height(10.dp))

        // Botón para comprar directamente el producto
        Button(
            onClick = { /* Acción comprar */ },
            colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2A3B66)),
            modifier = Modifier.fillMaxWidth(0.3f)
        ) {
            Text("Comprar", color = Color.White)
        }
    }
}

// Enlace para visitar la página oficial
@Composable
fun VisitLink() {

    // Texto que contiene la URL de la página oficial del producto
    Text(
        text = "Visitar Página Oficial",
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier.clickable { /* Acción para abrir el enlace */ }
    )
}


// Visualizar el fragment con el metodo Preview
@Preview(showBackground = true)
@Composable
fun PreviewShopView() {
    ShopViewScreen()
}