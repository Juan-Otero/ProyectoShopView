package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.SolidColor
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectopoli.R
import com.example.proyectopoli.model.Category
import com.example.proyectopoli.model.Product
import com.example.proyectopoli.model.ProductRepository
import com.example.proyectopoli.ui.theme.BlackButton
import com.example.proyectopoli.utils.formatPrice
import java.text.NumberFormat
import java.util.Locale

@Composable
fun HomeFragment(navController: NavController) {

    // Barra superior con ícono de menú y título
    Scaffold(
        topBar = { TopBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color(0xFFD4D8DE),
                            Color(0xFFEEEEEE)
                        )
                    )
                )
        ) {

            Spacer(modifier = Modifier.height(20.dp))

            // Logo principal del catalogo
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.icono_app),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(120.dp)
                        .clip(RoundedCornerShape(35))
                )
            }

            Spacer(modifier = Modifier.height(20.dp))


            // Sección: Categorías
            Text(
                text = "Categorías",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = BlackButton,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(25.dp))

            // Lista de las categorías disponibles
            val categories = listOf(
                Category.CELULARES,
                Category.LAPTOPS,
                Category.TABLETS,
                Category.ACCESORIOS
            )

            var categorySelected by remember { mutableStateOf<Category?> (null) }

            // Contenedor de los botones de filtrado por categoria
            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(categories) { category ->
                    CategoryCard(
                        category = category,
                        isSelected = categorySelected == category,
                        onClick = {
                            categorySelected = if (categorySelected == category) null else category
                        }
                    )
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = categorySelected?.displayName ?: "Destacados",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = BlackButton,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            // Funcionalidad de filtrado de productos
            val filteredProducts = if (categorySelected == null) {
                ProductRepository.getFeaturedProduct()
            } else {
                ProductRepository.getAllProducts().filter { it.prodCategory == categorySelected }
            }

            // Contenedor de producctos
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                contentPadding = PaddingValues(16.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp),
                verticalArrangement = Arrangement.spacedBy(12.dp),
                modifier = Modifier.fillMaxHeight()
            ) {
                items(filteredProducts) { product ->
                    ProductCard(product) {
                        navController.navigate("item/${product.prodId}")
                    }
                }
            }
        }
    }
}

// Botones de las categoría de productos
@Composable
fun CategoryCard(category: Category, isSelected: Boolean, onClick: () -> Unit) {
    val backgroundBrush = if (isSelected) {
        Brush.horizontalGradient(
            listOf(
                Color(0xFF1C6274),
                Color(0xFF2196F3)
            )
        )
    } else {
        SolidColor(Color(0xFF1565C0))
    }

    Card(
        modifier = Modifier
            .width(120.dp)
            .height(60.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(50),
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        ),
        elevation = CardDefaults.cardElevation(if (isSelected) 8.dp else 4.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundBrush, shape = RoundedCornerShape(50)),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = category.displayName,
                fontWeight = if (isSelected) FontWeight.Medium else FontWeight.Normal,
                fontSize = 18.sp,
                color = Color.White
            )
        }
    }
}

// Componente con las cartas de los productos (Nombre, Precio, Foto)
@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(166.dp)
            .height(220.dp)
            .clip(RoundedCornerShape(20.dp))
            .clickable(onClick = onClick)
            .shadow(elevation = 8.dp, shape = RoundedCornerShape(20.dp)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFFFFFFF))
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Text(
                product.prodName,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = product.imageResIds.firstOrNull() ?: R.drawable.logo_shopview),
                contentDescription = product.prodDescription,
                modifier = Modifier
                    .size(110.dp)
                    .clip(RoundedCornerShape(15))
            )

            Text(
                formatPrice(product.prodPrice),
                color = Color.DarkGray,
                fontSize = 16.sp
            )
        }
    }
}
