package dev.catbit.kobwebmaterial.foundation.locals

import androidx.compose.runtime.staticCompositionLocalOf
import dev.catbit.kobwebmaterial.foundation.shape.Shape

internal val LocalShape = staticCompositionLocalOf<Shape> {
    error("LocalShape not provided")
}