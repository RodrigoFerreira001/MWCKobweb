package com.catbit.mwckobweb.foundation.modifiers

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.ui.Modifier

@Composable
fun <T> Modifier.thenIfNotNull(
    value: T?,
    block: @Composable Modifier.(T) -> Modifier
): Modifier {
    return value?.let { this then(block(it)) } ?: this
}
