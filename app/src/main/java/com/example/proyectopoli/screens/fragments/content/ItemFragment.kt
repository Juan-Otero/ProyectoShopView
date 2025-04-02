package com.example.proyectopoli.screens.fragments.content

@Composable
@Preview
fun ItemFragment() {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = "Esta es la interfaz de cada Item",
            style = MaterialTheme.typography.headlineMedium,
            textAlign = TextAlign.Center
        )
    }
}