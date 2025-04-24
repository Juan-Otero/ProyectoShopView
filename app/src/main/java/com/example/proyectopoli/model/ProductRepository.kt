package com.example.proyectopoli.model

// Repositorio central que contiene todos los productos
object ProductRepository{

    // Función que retorna todos los productos existentes
    fun getAllProducts(): List<Product> {
        return listOf()
    }

    // Funcion que retorna los productos correspondientes a determinada categoría
    fun getCategories(): List<Category> {
        return listOf(
            Category.CELULARES,
            Category.LAPTOPS,
            Category.TABLETS,
            Category.ACCESORIOS
        )
    }

    // Función que retorna 5 productos para mostrarlos como destacados en la pantalla de Home
    fun getFeaturedProduct(): List<Product>{
        return getAllProducts().take(5)
    }
}