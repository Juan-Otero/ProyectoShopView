package com.example.proyectopoli.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.proyectopoli.model.ProductRepository
import com.example.proyectopoli.screens.fragments.content.BuscarFragment
import com.example.proyectopoli.screens.fragments.content.CarritoFragment
import com.example.proyectopoli.screens.fragments.content.HistorialFragment
import com.example.proyectopoli.screens.fragments.content.HomeFragment
import com.example.proyectopoli.screens.fragments.content.InicioFragment
import com.example.proyectopoli.screens.fragments.content.ItemFragment
import com.example.proyectopoli.screens.fragments.content.LoginFragment
import com.example.proyectopoli.screens.fragments.content.PedidoFragment
import com.example.proyectopoli.screens.fragments.content.PerfilFragment
import com.example.proyectopoli.screens.fragments.content.RegistroFragment
import com.example.proyectopoli.screens.fragments.content.WebFragment

@Composable
fun AppNavigation(navController: NavHostController) {
    NavHost(navController = navController, startDestination = "inicio") {

        // Rutas de navegación para el menú lateral
        composable("inicio"){
            InicioFragment(navController)
        }
        composable("login"){
            LoginFragment(navController)
        }
        composable("registro"){
            RegistroFragment(navController)
        }
        composable("home") {
            HomeFragment(navController)
        }
        composable("perfil"){
            PerfilFragment(navController)
        }
        composable("buscar") {
            BuscarFragment(navController)
        }
        composable("carrito"){
            CarritoFragment(navController)
        }
        composable("web"){
            WebFragment(navController)
        }
        composable("historial"){
            HistorialFragment(navController)
        }
        composable("pedido"){
            PedidoFragment(navController)
        }

        // Ruta de navegación para mostrar la información de los productos
        composable(
            "item/{productId}",
            arguments = listOf(navArgument("productId") { type = NavType.IntType })
        ) { backStackEntry ->
            val productId = backStackEntry.arguments?.getInt("productId")
            val product = ProductRepository.getById(productId ?: 0)
            if (product != null) {
                ItemFragment(product = product, navController = navController)
            } else {
                // Aquí puedes mostrar un error o volver a la pantalla anterior
                Text("Producto no encontrado")
            }
        }
    }
}