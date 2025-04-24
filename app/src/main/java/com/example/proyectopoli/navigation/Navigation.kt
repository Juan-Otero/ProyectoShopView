package com.example.proyectopoli.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import com.example.proyectopoli.screens.fragments.content.HistorialFragment
import com.example.proyectopoli.screens.fragments.content.BuscarFragment
import com.example.proyectopoli.screens.fragments.content.HomeFragment
import com.example.proyectopoli.screens.fragments.content.PerfilFragment
import com.example.proyectopoli.screens.fragments.content.CarritoFragment
import com.example.proyectopoli.screens.fragments.content.InicioFragment
import com.example.proyectopoli.screens.fragments.content.LoginFragment
import com.example.proyectopoli.screens.fragments.content.PedidoFragment
import com.example.proyectopoli.screens.fragments.content.RegistroFragment
import com.example.proyectopoli.screens.fragments.content.WebFragment


// Rutas de navegación de la aplicación
@Composable
fun ContentNavigation(selectedOption: String, navController: NavController) {
    when (selectedOption) {
        "inicio" -> InicioFragment()
        "login" -> LoginFragment()
        "registro" -> RegistroFragment()
        "home" -> HomeFragment(navController)
        "perfil" -> PerfilFragment()
        "buscar" -> BuscarFragment(navController)
        "carrito" -> CarritoFragment()
        "web" -> WebFragment()
        "historial" -> HistorialFragment()
        "pedido" -> PedidoFragment()
        else -> PerfilFragment()
    }
}