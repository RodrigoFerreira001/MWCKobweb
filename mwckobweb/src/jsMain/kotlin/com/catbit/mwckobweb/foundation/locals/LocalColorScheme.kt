package com.catbit.mwckobweb.foundation.locals

import androidx.compose.runtime.staticCompositionLocalOf
import com.catbit.mwckobweb.foundation.color.ColorScheme

internal val LocalColorScheme = staticCompositionLocalOf<ColorScheme> {
    error("LocalColorScheme not provided")
}