package com.example.proyectopoli.screens.fragments.content.menu

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.History
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.ListAlt
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.proyectopoli.model.MenuItem
import com.example.proyectopoli.ui.theme.components.DrawerItem

@Composable
fun MenuFragment(
    selectedOption: String,
    onOptionSelected: (String) -> Unit
) {
    val menuItems = listOf(
        MenuItem(id = "home", title = "Home", icon = Icons.Default.Home),
        MenuItem(id = "perfil", title = "Perfil", icon = Icons.Default.AccountCircle),
        MenuItem(id = "buscar", title = "Buscar", icon = Icons.Default.Search),
        MenuItem(id = "resumen", title = "Resúmen", icon = Icons.Default.ListAlt),
        MenuItem(id = "carrito", title = "Carrito", icon = Icons.Default.ShoppingCart),
        MenuItem(id = "historial", title = "Historial", icon = Icons.Default.History)
    )

    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        Text(
            text = "Menú",
            style = MaterialTheme.typography.titleLarge,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 24.dp)
        )

        Divider()

        LazyColumn {
            items(menuItems) { item ->
                DrawerItem(
                    item = item,
                    selected = selectedOption == item.id,
                    onItemClick = { onOptionSelected(item.id) }
                )
            }
        }
    }
}