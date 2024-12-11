package com.mbougar.ejerciciopmdmmanuelbouza.ui.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable

@Composable
fun PasswordVisibilityToggleIcon(
    showPassword: Boolean,
    onTogglePasswordVisibility: () -> Unit
) {

    // Android studio no me esta aceptando Icons extenden en la implementacion, asique he puesto unos iconos que no son los correctos
    val image = if (showPassword) Icons.Filled.Lock else Icons.Filled.Lock
    val contentDescription = if (showPassword) "Hide password icon" else "Show password icon"

    IconButton(onClick = onTogglePasswordVisibility) {
        Icon(imageVector = image,
            contentDescription = contentDescription)
    }
}