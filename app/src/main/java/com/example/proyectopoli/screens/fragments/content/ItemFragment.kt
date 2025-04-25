package com.example.proyectopoli.screens.fragments.content

// Importación de librerias necesarias
import android.content.Intent
import android.net.Uri
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectopoli.model.Product
import com.example.proyectopoli.ui.theme.BlackButton
import com.example.proyectopoli.ui.theme.BlueButton
import com.example.proyectopoli.ui.theme.BlueTopBar
import com.example.proyectopoli.screens.components.ImageCarousel
import com.example.proyectopoli.screens.components.VideoPlayer

// Vista general del fragmento y fijación de la barra superior
@Composable
fun ItemFragment(product: Product, navController: NavController) {
    Scaffold(
        topBar = { TopBar(navController) } // Fijar la barra superior
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())
                .background(Color.White),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            // Espacios para ajustar la informacion del producto (Imagen, Descripción, Acciones)
            Spacer(modifier = Modifier.height(10.dp))
            ProductImage(product.imageResIds, product.videoResId)
            Spacer(modifier = Modifier.height(20.dp))
            ProductInfo(product)
            Spacer(modifier = Modifier.height(50.dp))
            Spacer(modifier = Modifier.height(80.dp))
            VisitLink(product.officialUrl)
            Spacer(modifier = Modifier.height(30.dp)) // Espacio final para evitar recorte
        }
    }
}


// Componente de la barra superior
@OptIn(ExperimentalMaterial3Api::class) // Utiliza la API experimental Material3 para crear la barra
@Composable
fun TopBar(navController: NavController) {
    TopAppBar(
        // Botón para para retroceder en la barra superior
        navigationIcon = {
            IconButton(
                onClick = { navController.popBackStack() },
                modifier = Modifier.size(44.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBack,
                    contentDescription = "Retroceder",
                    tint = Color.White,
                    modifier = Modifier.size(28.dp)
                )
            }
        },

        // Nombre de la aplicación en la barra superior
        title = {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text("ShopView", fontWeight = FontWeight.Bold, color = Color.White, fontStyle = FontStyle.Italic)
                    Spacer(modifier = Modifier.width(40.dp))
                }
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(containerColor = BlueTopBar)
    )
}


/* SECCIÓN DE PRODUCTO */
// Componente de las imagenes y videos del producto con las flechas para desplazarlas
@Composable
fun ProductImage(images: List<Int>, video: Int) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier.padding(top = 10.dp)
    ) {
        ImageCarousel(images = images)

        Spacer(modifier = Modifier.height(20.dp))

        VideoPlayer(
            videoResId = video,
            modifier = Modifier
                .fillMaxWidth()
                .height(250.dp)
                .padding(horizontal = 16.dp)
        )
    }
}

// Componente de informacion detallada del producto
@Composable
fun ProductInfo(product: Product) {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(product.prodName, fontWeight = FontWeight.Bold, fontSize = 28.sp, color = Color.Black) // Nombre del producto
        Spacer(modifier = Modifier.height(18.dp))
        Text(product.prodDescription, fontSize = 22.sp, color = Color.Gray, textAlign = TextAlign.Center) // Descripción del Producto
        Spacer(modifier = Modifier.height(30.dp))
        Text(formatPrice(product.prodPrice), fontWeight = FontWeight.Bold, fontSize = 36.sp, color = Color.Black) // Precio del Producto
    }
}


// Botones de agregar al carrito y comprar
@Composable
fun ActionButtons() {
    Column(horizontalAlignment = Alignment.CenterHorizontally) {

        // Botón para agregar el producto al carrito
        Button(
            onClick = { /* Acción agregar al carrito */ },
            colors = ButtonDefaults.buttonColors(containerColor = BlackButton),
            modifier = Modifier.fillMaxWidth(0.6f)
        ) {
            Text("Agregar a carrito", fontWeight = FontWeight.Bold, fontSize = 21.sp, color = Color.White)
        }

        Spacer(modifier = Modifier.height(15.dp))

        // Botón para comprar directamente el producto
        Button(
            onClick = { /* Acción comprar */ },
            colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
            modifier = Modifier.fillMaxWidth(0.4f)
        ) {
            Text("Comprar", fontWeight = FontWeight.Bold, fontSize = 20.sp, color = Color.White)
        }
    }
}

// Enlace para visitar la página oficial
@Composable
fun VisitLink(officalUrl: String) {

    val context = LocalContext.current

    // Texto que contiene la URL de la página oficial del producto
    Text(
        text = "Visitar Página Oficial",
        color = Color.Black,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        textDecoration = TextDecoration.Underline,
        modifier = Modifier.clickable {
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(officalUrl))
            context.startActivity(intent)
        }
    )
}