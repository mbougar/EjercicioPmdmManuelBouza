package com.mbougar.ejerciciopmdmmanuelbouza.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF4CAF50),
    onPrimary = Color.White,
    background = Color.White,
    surface = Color(0xFF4CAF50),
    onBackground = Color.Black,
    onSurface = Color.Black
)

@Composable
fun MyAppTheme(content: @Composable () -> Unit) {
    val colors = DarkColorScheme

    MaterialTheme(
        colorScheme = colors,
        typography = ProximaTypography,
        content = content
    )
}