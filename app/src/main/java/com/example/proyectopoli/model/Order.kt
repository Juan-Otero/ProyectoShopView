package com.example.proyectopoli.model

import com.example.proyectopoli.screens.fragments.content.OrderProduct

data class Order(
    val id: String,
    val products: List<OrderProduct>
)