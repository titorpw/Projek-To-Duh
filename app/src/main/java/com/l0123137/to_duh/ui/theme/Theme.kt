package com.l0123137.to_duh.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Turquoise,
    onPrimary = Color.Black,
    primaryContainer = SteelBlue,
    onPrimaryContainer = Color.White,
    secondary = TealBlue,
    onSecondary = Color.White,
    background = DarkCyan,
    onBackground = Color.Black,
    surface = DarkCyan,
    onSurface = Color.White,
    error = CoralRed,
    onError = Color.Black,
)

private val LightColorScheme = lightColorScheme(
    primary = Turquoise,
    onPrimary = Color.White,
    primaryContainer = SteelBlue,
    onPrimaryContainer = Color.White,
    secondary = TealBlue,
    onSecondary = Color.White,
    background = Color.White,
    onBackground = DarkCyan,
    surface = Color.White,
    onSurface = Color.Black,
    error = CoralRed,
    onError = Color.White,
)

@Composable
fun ToDuhTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}