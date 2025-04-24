package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.proyectopoli.R
import com.example.proyectopoli.ui.theme.BlackButton

// Lista de los productos agregados
data class OrderProduct(val product: String, val price: Int)

@Preview
@Composable
fun PedidoFragment() {

    // Reutilizaación de la barra superior del FragmentItem
    Scaffold(
        topBar = { TopBar() }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            // Carta que contiene los detalles del carrito
            Card(
                border = BorderStroke(2.dp, Color.Gray),
                elevation = CardDefaults.cardElevation(0.dp),
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
            ) {

                // Caja que encierra el contenido para dar fondo de degradado
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(
                            brush = Brush.verticalGradient(
                                colors = listOf(
                                    Color(0xFFE0E0E0),
                                    Color.White,
                                    Color(0xFFE0E0E0),
                                )
                            )
                        )
                        .padding(15.dp)
                ) {

                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp),
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {

                        // Titulo con el consecutivo del pedido
                        Text(
                            text = "Pedido\n#00000",
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                            textAlign = TextAlign.Center,
                            color = BlackButton,
                        )

                        Spacer(modifier = Modifier.height(50.dp))

                        // Listado de productos
                        val productos = listOf(
                            OrderProduct("Producto 3", 20000),
                            OrderProduct("Producto 4", 113500),
                            OrderProduct("Producto 1", 41000),
                            OrderProduct("Producto 2", 32000),
                        )

                        // Algoritmo para mostrar los productos del pedido y su precio
                        var total = 0
                        productos.forEach { producto ->
                            total += producto.price
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 15.dp, horizontal = 20.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text("• ${producto.product}", fontSize = 20.sp, fontWeight = FontWeight.SemiBold)
                                Text(text = formatearPrecio(producto.price), fontSize = 20.sp)
                            }
                        }

                        Spacer(modifier = Modifier.height(40.dp))

                        // Precio total del pedido
                        Text(
                            text = formatearPrecio(total),
                            fontSize = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = BlackButton,
                            modifier = Modifier
                                .align(Alignment.CenterHorizontally)
                                .padding(top = 12.dp)
                        )
                    }
                }
            }

            Spacer(Modifier.height(20.dp))

            // Logo de la aplicación
            Image(
                painter = painterResource(id = R.drawable.logo_shopview),
                contentDescription = "Logo",
                modifier = Modifier.size(150.dp)
                    .clip(RoundedCornerShape(50.dp))
            )
        }
    }
}