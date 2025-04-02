package dev.catbit.mwckobweb.foundation.locals

import androidx.compose.runtime.staticCompositionLocalOf
import dev.catbit.mwckobweb.foundation.shape.Shape

internal val LocalShape = staticCompositionLocalOf<Shape> {
    error("LocalShape not provided")
}