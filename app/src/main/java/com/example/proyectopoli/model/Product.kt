package com.example.proyectopoli.model

// Clase para la información de cada producto
data class Product(
    val prodName: String,
    val prodDescription: String,
    val prodPrice: Double,
    val prodCategory: Category,
    val officialUrl: String,
    val imageResIds: List<Int>,
    val videoResId: Int
)