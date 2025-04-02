package dev.catbit.mwckobweb.foundation.locals

import androidx.compose.runtime.staticCompositionLocalOf
import dev.catbit.mwckobweb.foundation.color.ColorScheme

internal val LocalColorScheme = staticCompositionLocalOf<ColorScheme> {
    error("LocalColorScheme not provided")
}