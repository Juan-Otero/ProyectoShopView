package com.example.proyectopoli.screens.components

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

// Componente reutilizable para mostrar el video trailer del producto
@Composable
fun VideoPlayer(videoResId: Int, modifier: Modifier = Modifier) {
    val context = LocalContext.current

    // Variable que almacena la ubicación del archivo multimedia
    val videoUri = Uri.parse("android.resource://${context.packageName}/$videoResId")

    // Vista de tipo video para mostrar en pantalla el archivo
    AndroidView(
        factory = { ctx ->
            VideoView(ctx).apply {
                setVideoURI(videoUri)

                val controller = MediaController(ctx).apply {
                    setAnchorView(this@apply)
                }

                setMediaController(controller)
                requestFocus()

                setOnPreparedListener {
                    start()
                    controller.show()
                }
            }
        },
        modifier = modifier
    )
}
