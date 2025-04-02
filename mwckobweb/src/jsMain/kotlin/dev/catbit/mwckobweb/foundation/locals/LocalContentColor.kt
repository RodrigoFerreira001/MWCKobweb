package dev.catbit.mwckobweb.foundation.locals

import androidx.compose.runtime.compositionLocalOf
import org.jetbrains.compose.web.css.CSSColorValue

val LocalContentColor = compositionLocalOf<CSSColorValue> {
    error("LocalContentColor not provided")
}