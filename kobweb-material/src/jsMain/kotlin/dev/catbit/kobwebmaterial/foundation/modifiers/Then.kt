package dev.catbit.kobwebmaterial.foundation.modifiers

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier

@Composable
infix fun Modifier.then(block: @Composable Modifier.() -> Modifier): Modifier {
    return this then(block())
}