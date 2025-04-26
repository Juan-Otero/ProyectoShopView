package com.example.proyectopoli.model

import com.example.proyectopoli.screens.fragments.content.OrderProduct

object OrderRepository {
    private val orders = listOf(
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

    fun getOrderById(id: String): Order? {
        return orders.find { it.id == id }
    }
}