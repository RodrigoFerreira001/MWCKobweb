package dev.catbit.mwckobweb.foundation.modifiers

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier

@Composable
fun Modifier.thenIf(
    condition: Boolean, block: @Composable Modifier.() -> Modifier
): Modifier {
    return if (condition) this then(block()) else this
}
