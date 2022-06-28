package org.zky.genshinwidgets.res

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight

object themes {

    val LocalMyColors = staticCompositionLocalOf<ThemeColor> {
        color
    }

    val colors: ThemeColor
        @Composable
        get() = LocalMyColors.current

    @Composable
    fun Theme(
        darkTheme: Boolean = isSystemInDarkTheme(),
        content: @Composable () -> Unit,
    ) {
        val myColors = if (darkTheme) {
            color.night
        } else {
            color
        }
        CompositionLocalProvider(
            LocalMyColors provides myColors
        ) {
            MaterialTheme(
                colors = MaterialTheme.colors.copy(
                    primary = myColors.primary,
                    secondary = myColors.secondary,
                    background = myColors.background,
                    error = myColors.error,
                    surface = myColors.surface,
                    onSurface = myColors.onSurface,
                    isLight = !darkTheme
                ),
                typography = MaterialTheme.typography.copy(
                    body1 = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Normal,
                        fontSize = font.bodyM,
                        color = myColors.textPrimary
                    ),
                    body2 = TextStyle(
                        fontFamily = FontFamily.Default,
                        fontWeight = FontWeight.Normal,
                        fontSize = font.bodyL,
                        color = myColors.textPrimary
                    )
                ),
                content = content
            )
        }

    }
}