package com.example.proyectopoli.data

import com.example.proyectopoli.model.Product

object CartManager {
    private val cartItems = mutableListOf<Product>()

    fun addToCart(product: Product) {
        cartItems.add(product)
    }

    fun removeFromCart(product: Product) {
        cartItems.remove(product)
    }

    fun getCartItems(): List<Product> {
        return cartItems
    }

    fun getTotalPrice(): Double {
        return cartItems.sumOf { it.prodPrice }
    }

    fun clearCart() {
        cartItems.clear()
    }
}
