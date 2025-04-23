package com.example.proyectopoli.screens.components

import android.net.Uri
import android.widget.MediaController
import android.widget.VideoView
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@Composable
fun VideoPlayer(videoResId: Int, modifier: Modifier = Modifier) {
    val context = LocalContext.current
    val videoUri = Uri.parse("android.resource://${context.packageName}/$videoResId")

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
