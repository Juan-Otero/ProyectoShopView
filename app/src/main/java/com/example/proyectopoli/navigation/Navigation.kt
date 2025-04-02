package com.example.proyectopoli.navigation

import androidx.compose.runtime.Composable
import com.example.proyectopoli.screens.fragments.content.HistorialFragment
import com.example.proyectopoli.screens.fragments.content.BuscarFragment
import com.example.proyectopoli.screens.fragments.content.HomeFragment
import com.example.proyectopoli.screens.fragments.content.PerfilFragment
import com.example.proyectopoli.screens.fragments.content.ResumenFragment
import com.example.proyectopoli.screens.fragments.content.CarritoFragment

@Composable
fun ContentNavigation(selectedOption: String) {
    when (selectedOption) {
//        "inicio" -> InicioFragment()
//        "login" -> LoginFragment()
//        "registro" -> RegistroFragment()
        "home" -> HomeFragment()
        "perfil" -> PerfilFragment()
        "buscar" -> BuscarFragment()
        "resumen" -> ResumenFragment()
        "carrito" -> CarritoFragment()
        "historial" -> HistorialFragment()
        else -> PerfilFragment()
    }
}