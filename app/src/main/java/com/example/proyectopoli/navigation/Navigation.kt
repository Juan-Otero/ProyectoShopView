package com.example.proyectopoli.navigation

import androidx.compose.runtime.Composable
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

@Composable
fun ContentNavigation(selectedOption: String) {
    when (selectedOption) {
        "inicio" -> InicioFragment()
        "login" -> LoginFragment()
        "registro" -> RegistroFragment()
        "home" -> HomeFragment()
        "perfil" -> PerfilFragment()
        "buscar" -> BuscarFragment()
        "carrito" -> CarritoFragment()
        "web" -> WebFragment()
        "historial" -> HistorialFragment()
        "pedido" -> PedidoFragment()
        else -> PerfilFragment()
    }
}