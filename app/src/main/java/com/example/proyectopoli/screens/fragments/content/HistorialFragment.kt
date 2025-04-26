package com.example.proyectopoli.screens.fragments.content

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
                        Triple("#000000", "XX items", Icons.Default.Receipt),
                        Triple("#111111", "XX items", Icons.Default.Receipt),
                        Triple("#222222", "XX items", Icons.Default.Receipt),
                        Triple("#333333", "XX items", Icons.Default.Receipt)

                    )

                    orders.forEach { (id, items, icon) ->
                        OrderItemStyled(
                            orderId = id,
                            itemCount = items,
                            icon = icon,
                            onClick = {
                                navController.navigate("pedido/${id}")
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
fun OrderItemStyled(orderId: String, itemCount: String, icon: ImageVector, onClick: () -> Unit) {
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
                imageVector = icon,
                contentDescription = "Ícono Pedido",
                tint = Color.Black,
                modifier = Modifier.size(24.dp)
            )

            Spacer(modifier = Modifier.width(16.dp))

            Column(
                modifier = Modifier.weight(1f)
            ) {
                Text(
                    text = "Pedido $orderId",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Light,
                    color = BlackButton
                )
                Text(
                    text = itemCount,
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