package com.example.proyectopoli.screens.fragments.content

import android.widget.Toast
import androidx.compose.ui.draw.clip
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.proyectopoli.data.CartManager
import com.example.proyectopoli.model.Product
import com.example.proyectopoli.ui.theme.BlackButton
import com.example.proyectopoli.ui.theme.BlueButton
import com.example.proyectopoli.ui.theme.RedButton
import java.text.NumberFormat
import java.util.*

@Composable
fun CarritoFragment(navController: NavController) {
    val context = LocalContext.current
    var cartItems by remember { mutableStateOf(CartManager.getCartItems()) }
    var total by remember { mutableStateOf(CartManager.getTotalPrice()) }

    Scaffold(
        topBar = { TopBar(navController) }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .background(Color.White)
        ) {
            Spacer(modifier = Modifier.height(8.dp))

            Card(
                border = BorderStroke(2.dp, Color.Gray),
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxSize()
                    .clip(RoundedCornerShape(12.dp)),
                elevation = CardDefaults.cardElevation(0.dp)
            ) {
                Box(
                    modifier = Modifier
                        .background(
                            Brush.verticalGradient(
                                colors = listOf(Color(0xFFE0E0E0), Color.White)
                            )
                        )
                        .padding(16.dp)
                ) {
                    Column(horizontalAlignment = Alignment.CenterHorizontally) {

                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.fillMaxWidth()
                        ) {
                            Text(
                                text = "Resumen de\nla compra",
                                fontSize = 28.sp,
                                color = BlackButton,
                                modifier = Modifier.weight(1f)
                            )
                            Icon(
                                imageVector = Icons.Default.ShoppingCart,
                                contentDescription = "Carrito",
                                modifier = Modifier.size(38.dp)
                            )
                        }

                        Spacer(modifier = Modifier.height(20.dp))

                        if (cartItems.isEmpty()) {
                            Text(
                                text = "Tu carrito está vacío.",
                                fontSize = 22.sp,
                                color = Color.Gray,
                                modifier = Modifier.padding(vertical = 40.dp)
                            )
                        } else {
                            cartItems.forEach { product ->
                                CartItem(
                                    product = product,
                                    onRemove = {
                                        CartManager.removeFromCart(product)
                                        cartItems = CartManager.getCartItems()
                                        total = CartManager.getTotalPrice()
                                    }
                                )
                            }

                            Spacer(modifier = Modifier.height(40.dp))

                            Text(
                                text = formatearPrecio(total),
                                fontSize = 40.sp,
                                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                                color = BlackButton
                            )

                            Spacer(modifier = Modifier.height(30.dp))

                            Button(
                                onClick = {
                                    Toast.makeText(context, "¡Compra finalizada exitosamente!", Toast.LENGTH_SHORT).show()
                                    CartManager.clearCart()
                                    cartItems = CartManager.getCartItems()
                                    total = CartManager.getTotalPrice()
                                },
                                colors = ButtonDefaults.buttonColors(containerColor = BlueButton),
                                modifier = Modifier
                                    .width(220.dp)
                                    .height(50.dp)
                            ) {
                                Text(
                                    text = "Finalizar Compra",
                                    color = Color.White,
                                    fontSize = 20.sp,
                                    fontWeight = androidx.compose.ui.text.font.FontWeight.Bold
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun CartItem(product: Product, onRemove: () -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text("• ${product.prodName}", fontSize = 18.sp)
        Text(formatearPrecio(product.prodPrice), fontSize = 18.sp)
        IconButton(
            onClick = { onRemove() },
            modifier = Modifier
                .size(30.dp)
                .background(RedButton, shape = RoundedCornerShape(50))
        ) {
            Icon(
                imageVector = Icons.Default.Delete,
                contentDescription = "Eliminar",
                tint = Color.White
            )
        }
    }
}

fun formatearPrecio(valor: Double): String {
    val formato = NumberFormat.getCurrencyInstance(Locale("es", "CO"))
    return formato.format(valor)
}
