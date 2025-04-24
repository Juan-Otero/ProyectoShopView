package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
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
import java.text.NumberFormat
import java.util.Locale

@Composable
fun HomeFragment(navController: NavController) {

    // Barra superior con ícono de menú y título
    Scaffold(
        topBar = { TopBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
                .background(
                    brush = Brush.verticalGradient(
                        listOf(
                            Color(0xFFE0E0E0),
                            Color(0xFF8B8B8B)
                        )
                    )
                )
        ) {

            Spacer(modifier = Modifier.height(30.dp))

            // Logo principal del catalogo
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo_shopview),
                    contentDescription = "Logo",
                    modifier = Modifier
                        .size(180.dp)
                        .clip(RoundedCornerShape(35))
                )
            }

            Spacer(modifier = Modifier.height(50.dp))


            // Sección: Categorías
            Text(
                text = "Categorías",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = BlackButton,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            val categories = listOf(
                Category.CELULARES,
                Category.LAPTOPS,
                Category.TABLETS,
                Category.ACCESORIOS
            )

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(categories) { category ->
                    CategoryCard(category)
                }
            }

            Spacer(modifier = Modifier.height(50.dp))

            Text(
                text = "Destacados",
                fontSize = 26.sp,
                fontWeight = FontWeight.Bold,
                color = BlackButton,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Spacer(modifier = Modifier.height(15.dp))

            LazyRow(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                horizontalArrangement = Arrangement.spacedBy(12.dp)
            ) {
                items(ProductRepository.getFeaturedProduct()) { product ->
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
fun CategoryCard(category: Category) {
    Card(
        modifier = Modifier
            .width(120.dp)
            .height(60.dp),
        shape = RoundedCornerShape(50),
        colors = CardDefaults.cardColors(containerColor = Color.Transparent),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color(0xFF578FCA),
                            Color(0xFF2A3B65)
                        )
                    )
                )
        ) {
            // Texto centrado
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.fillMaxSize()
            ) {
                Text(
                    text = category.displayName,
                    fontWeight = FontWeight.Medium,
                    fontSize = 18.sp,
                    color = Color.White
                )
            }
        }
    }
}

// Componente con las cartas de los productos (Nombre, Precio, Foto)
@Composable
fun ProductCard(product: Product, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(176.dp)
            .height(220.dp)
            .clip(RoundedCornerShape(20)),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFE0E0E0))
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
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                color = Color.Black,
                textAlign = TextAlign.Center
            )

            Image(
                painter = painterResource(id = product.imageResIds.firstOrNull() ?: R.drawable.logo_shopview),
                contentDescription = product.prodDescription,
                modifier = Modifier
                    .size(100.dp)
                    .clip(RoundedCornerShape(15))
            )

            Text(
                formatPrice(product.prodPrice),
                color = Color.DarkGray,
                fontSize = 18.sp
            )
        }
    }
}

// Funcion para formatear el precio con separador de miles
fun formatPrice(price: Double): String {
    val format = NumberFormat.getNumberInstance(Locale("es", "CO"))
    format.minimumFractionDigits = 0
    format.maximumFractionDigits = 0
    return "$${format.format(price)}"
}