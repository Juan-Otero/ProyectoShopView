package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
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
import androidx.compose.material.icons.filled.Remove
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopoli.ui.theme.BlackButton
import com.example.proyectopoli.ui.theme.BlueButton
import com.example.proyectopoli.ui.theme.RedButton
import java.text.NumberFormat
import java.util.Locale

// Lista de los productos agregados
data class CartProduct(val product: String, val price: Int)

@Preview
@Composable
fun CarritoFragment() {

    // Reutilizaación de la barra superior del FragmentItem
    Scaffold(
        topBar = { TopBar() }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(6.dp))

            // Carta que contiene los detalles del carrito
            Card(
                border = BorderStroke(2.dp, Color.Gray),
                elevation = CardDefaults.cardElevation(0.dp),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp))
            ) {

                // Caja que encierra el contenido para dar fondo de degradado
                Box(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFE0E0E0), // color inicial
                                    Color.White
                                )
                            )
                        )
                        .padding(16.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        // Título con ícono de carrito
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center
                        ) {
                            Text(
                                text = "Resumen\nCarrito",
                                fontWeight = FontWeight.Bold,
                                fontSize = 28.sp,
                                textAlign = TextAlign.Center,
                                color = BlackButton,
                                modifier = Modifier.weight(1f)
                            )
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Carrito",
                                modifier = Modifier.size(38.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(25.dp))

                        // Listado de productos
                        val productos = listOf(
                            CartProduct("Producto 1", 54000),
                            CartProduct("Producto 2", 72000),
                            CartProduct("Producto 3", 25000),
                            CartProduct("Producto 4", 32000)
                        )

                        // Algoritmo para mostrar los productos que se agreguen y su precio
                        var total = 0
                        productos.forEach { producto ->
                            total += producto.price
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 10.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("• ${producto.product}", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                                Text(text = formatearPrecio(producto.price), fontSize = 20.sp)

                                // Botón para remover un producto
                                IconButton(
                                    onClick = { /* Acción para eliminar */ },
                                    modifier = Modifier
                                        .size(25.dp)
                                        .background(RedButton, shape = RoundedCornerShape(25.dp))
                                        .padding(end = 0.5.dp)
                                ) {
                                    Icon(
                                        imageVector = Icons.Default.Remove,
                                        contentDescription = "Eliminar",
                                        tint = Color.White,
                                        modifier = Modifier.size(24.dp)
                                    )
                                }
                            }
                        }

                        Spacer(modifier = Modifier.height(120.dp))

                        // Precio total del carrito
                        Text(
                            text = formatearPrecio(total),
                            fontSize = 45.sp,
                            fontWeight = FontWeight.Bold,
                            color = BlackButton,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 12.dp)
                        )

                        Spacer(modifier = Modifier.height(40.dp))

                        // Botón de Finalizar Compra
                        Button(
                            onClick = { /* lógica de compra */ },
                            colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                            modifier = Modifier
                                .width(220.dp)
                                .height(50.dp)
                                .clip(RoundedCornerShape(25.dp))
                        ) {
                            Text(
                                "Finalizar Compra",
                                color = Color.White,
                                fontSize = 21.sp,
                                fontWeight = FontWeight.Bold
                            )
                        }
                    }
                }
            }
        }
    }
}

// Función para formatear los precios y mostrarlos con separador de miles
fun formatearPrecio(valor: Int): String {
    val formato = NumberFormat.getNumberInstance(Locale("es", "CO"))
    return "$${formato.format(valor)}"
}