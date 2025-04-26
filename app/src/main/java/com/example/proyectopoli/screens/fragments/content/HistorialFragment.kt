package com.example.proyectopoli.screens.fragments.content

import android.graphics.drawable.Icon
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material.icons.filled.ChevronRight
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Receipt
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectopoli.model.Order
import com.example.proyectopoli.ui.theme.BlackButton

@Composable
fun HistorialFragment(navController: NavController) {

    // Reutilización de la barra superior del fragment Item
    Scaffold(
        topBar = { TopBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Spacer(modifier = Modifier.height(50.dp))

            // Card grande que encierra el titulo y los pedidos
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp),
                shape = RoundedCornerShape(15.dp),
                border = BorderStroke(2.dp, Color(0xFFD7D7D7)),
                colors = CardDefaults.cardColors(containerColor = Color.White)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    // Título centrado con ícono
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        horizontalArrangement = Arrangement.Center,
                    ) {
                        Text(
                            "Historial de\nPedidos",
                            fontSize = 30.sp,
                            lineHeight = 40.sp,
                            fontWeight = FontWeight.Bold,
                            color = BlackButton,
                            textAlign = TextAlign.Center
                        )

                        Spacer(modifier = Modifier.width(15.dp))

                        Icon(
                            imageVector = Icons.Default.History,
                            contentDescription = "Historial",
                            tint = Color.Black,
                            modifier = Modifier.size(38.dp)
                        )
                    }

                    Spacer(modifier = Modifier.height(40.dp))

                    // Lista de los pedidos realizados
                    val orders = listOf(
                        Order(
                            id = "39010",
                            products = listOf(
                                OrderProduct("Iphone 15 Pro", 4899000),
                                OrderProduct("Lenovo | Ideapad", 2380000)
                            )
                        ),
                        Order(
                            id = "38201",
                            products = listOf(
                                OrderProduct("Acer Aspire 15.6' C7SG", 1300000),
                                OrderProduct("Samsung Galaxy Buds3 Pro", 640000),
                                OrderProduct("HyperX Quadcast S", 610000)
                            )
                        ),
                        Order(
                            id = "21803",
                            products = listOf(
                                OrderProduct("Honor Pad X8a 128GB", 635000)
                            )
                        )
                    )

                    orders.forEach { order ->
                        OrderItemStyled(
                            order = order,
                            onClick = {
                                // Aquí vamos a pasar el ID y también preparar la navegación con productos
                                navController.navigate("pedido/${order.id}")
                            }
                        )
                        Spacer(modifier = Modifier.height(35.dp))
                    }
                }
            }
        }
    }
}


// Componente reutilizable para las cartas de cada pedido
@Composable
fun OrderItemStyled(order: Order, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(72.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(12.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFEEEEEE))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.Receipt, // Ícono de pedido
                contentDescription = "Ícono Pedido",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Pedido ${order.id}",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    color = BlackButton
                )
                Text(
                    text = "${order.products.size} items",
                    fontWeight = FontWeight.Normal,
                    color = Color.DarkGray
                )
            }

            Icon(
                imageVector = Icons.Default.ChevronRight,
                contentDescription = "Detalles",
                tint = BlackButton
            )
        }
    }
}