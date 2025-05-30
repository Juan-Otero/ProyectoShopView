package com.example.proyectopoli.screens.fragments.content

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectopoli.R
import com.example.proyectopoli.model.OrderRepository
import com.example.proyectopoli.ui.theme.BlackButton

// Lista de los productos agregados
data class OrderProduct(val product: String, val price: Int)

@Composable
fun PedidoFragment(orderId: String, navController: NavController) {
    val order = remember { OrderRepository.getOrderById(orderId) }

    if (order == null) {
        Text("Pedido no encontrado")
        return
    }

    Scaffold(
        topBar = { TopBar(navController) }
    ) { paddingValues ->
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(20.dp))

            Card(
                border = BorderStroke(2.dp, Color.Gray),
                elevation = CardDefaults.cardElevation(0.dp),
                modifier = Modifier
                    .padding(20.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(12.dp))
            ) {
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
                        Text(
                            text = "Pedido\n#${order.id}",
                            fontWeight = FontWeight.Bold,
                            fontSize = 28.sp,
                            textAlign = TextAlign.Center,
                            color = BlackButton,
                        )

                        Spacer(modifier = Modifier.height(50.dp))

                        order.products.forEach { producto ->
                            Row(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(vertical = 15.dp, horizontal = 14.dp),
                                horizontalArrangement = Arrangement.SpaceBetween,
                                verticalAlignment = Alignment.CenterVertically
                            ) {
                                Text(
                                    "• ${producto.product}",
                                    fontSize = 18.sp,
                                    fontWeight = FontWeight.SemiBold,
                                    maxLines = 1,
                                    overflow = TextOverflow.Ellipsis,
                                    modifier = Modifier.weight(1f)
                                )

                                Spacer(modifier = Modifier.width(8.dp))

                                Text(
                                    text = formatearPrecio(producto.price.toDouble()),
                                    fontSize = 16.sp,
                                    fontWeight = FontWeight.Medium,
                                    textAlign = TextAlign.End,
                                    modifier = Modifier.widthIn(min = 80.dp)
                                )
                            }
                        }

                        Spacer(modifier = Modifier.height(40.dp))

                        val total = order.products.sumOf { it.price }

                        Text(
                            text = formatearPrecio(total.toDouble()),
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

            Image(
                painter = painterResource(id = R.drawable.logo_shopview),
                contentDescription = "Logo",
                modifier = Modifier
                    .size(150.dp)
                    .clip(RoundedCornerShape(50.dp))
            )
        }
    }
}
