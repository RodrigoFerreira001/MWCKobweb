package dev.catbit.kobwebmaterial.foundation.locals

import androidx.compose.runtime.staticCompositionLocalOf
import dev.catbit.kobwebmaterial.foundation.color.ColorScheme

internal val LocalColorScheme = staticCompositionLocalOf<ColorScheme> {
    error("LocalColorScheme not provided")
}