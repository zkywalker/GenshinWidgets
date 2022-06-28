package org.zky.genshinwidgets.res

import androidx.compose.ui.graphics.Color
import org.zky.genshinwidgets.R
import org.zky.genshinwidgets.utils.getColor

object color : ThemeColor(
    primary = getColor(R.color.primary),
    secondary = getColor(R.color.secondary),
    Tertiary = getColor(R.color.tertiary),
    error = getColor(R.color.error),
    background = getColor(R.color.background),
    textPrimary = getColor(R.color.textPrimary),
    textSecondary = getColor(R.color.textSecondary),
    textTertiary = getColor(R.color.textTertiary),
    surface = getColor(R.color.surface),
    onSurface = getColor(R.color.onSurface),
) {

    val white_70 = Color(0xB3FFFFFF)


    val exploring = Color(0xFFE0A157)
    val explored = Color(0xFFA9E143)
    val explored2 = Color(0xFF3E6C10)

    val black44 = Color(0x44000000)


    object night : ThemeColor(
        primary = Color(0xFF9ACBFF),
        secondary = Color(0xFFB5C8E0),
        Tertiary = Color(0xFFD7BCEE),
        error = Color(0xFFFFB4AB),
        background = Color(0xFF1A1C1E),
        textPrimary = Color(0xFFF1F0F4),
        textSecondary = Color(0xFFC2C7CF),
        textTertiary = Color(0xFF8C9199),
        surface = Color(0xFF42474E),
        onSurface = Color(0xFFE2E2E5),
    )

}