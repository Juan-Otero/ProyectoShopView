package com.example.proyectopoli.utils

fun formatPrice(price: Double): String {
    return "$${"%,.0f".format(price)}"
}
