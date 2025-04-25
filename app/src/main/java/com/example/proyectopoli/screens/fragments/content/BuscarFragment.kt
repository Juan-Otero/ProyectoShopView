package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectopoli.model.ProductRepository
import com.example.proyectopoli.ui.theme.BlackButton


// PANTALLA DE BÚSQUEDA DE PRODUCTOS
@Composable
fun BuscarFragment(navController: NavController) {
    var searchQuery by remember { mutableStateOf("") } // Variable que almacena el nombre del producto buscado
    val allProduct = ProductRepository.getAllProducts() // Listado de todos los productos del catalogo

    // Barra superior de fragment Item
    Scaffold(
        topBar = { TopBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(40.dp))

            // Campo de búsqueda
            OutlinedTextField(
                value = searchQuery,
                onValueChange = { searchQuery = it },
                placeholder = { Text(
                    "Buscar producto",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Normal,
                    color = Color.Gray) },

                modifier = Modifier
                    .padding(horizontal = 20.dp)
                    .fillMaxWidth()
                    .height(60.dp),

                shape = RoundedCornerShape(40),
                trailingIcon = {
                    if (searchQuery.isNotEmpty()) {
                        IconButton(onClick = { searchQuery = "" }) {
                            Icon(Icons.Default.Close, contentDescription = "Limpiar búsqueda")
                        }
                    }
                },
                colors = OutlinedTextFieldDefaults.colors(
                    unfocusedContainerColor = Color.White,
                    focusedContainerColor = Color.White
                )
            )

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Resultados para búsqueda",
                fontSize = 30.sp,
                fontWeight = FontWeight.Light,
                color = BlackButton,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                textAlign = TextAlign.Center
            )

            Spacer(modifier = Modifier.height(50.dp))

            // Grid de productos
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = 16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(26.dp)
            ) {

                // Filtrado para mostrar solo los productos buscados
                val filteredProducts = allProduct.filter { product ->
                    product.prodName.contains(searchQuery, ignoreCase = true)
                }

                // Lista de productos de prueba
                items(filteredProducts) { product ->
                    ProductCard(product = product, onClick = {
                        navController.navigate("item/${product.prodId}")
                    })
                }
            }
        }
    }
}