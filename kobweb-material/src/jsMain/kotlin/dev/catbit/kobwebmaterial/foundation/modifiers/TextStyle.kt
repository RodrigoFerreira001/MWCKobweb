package dev.catbit.kobwebmaterial.foundation.modifiers

import androidx.compose.runtime.Composable
import dev.catbit.kobwebmaterial.foundation.text.TextStyle
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.*

@Composable
fun Modifier.textStyle(textStyle: TextStyle): Modifier {
    return this then(
        Modifier
            .thenIfNotNull(textStyle.color) { color(it) }
            .thenIfNotNull(textStyle.fontSize) { fontSize(it) }
            .thenIfNotNull(textStyle.fontStyle) { fontStyle(it) }
            .thenIfNotNull(textStyle.fontWeight) { fontWeight(it) }
            .thenIfNotNull(textStyle.fontFamily) { fontFamily(it.name) }
            .thenIfNotNull(textStyle.letterSpacing) { letterSpacing(it) }
            .thenIfNotNull(textStyle.textDecoration) { textDecorationLine(it) }
            .thenIfNotNull(textStyle.textAlign) { textAlign(it) }
            .thenIfNotNull(textStyle.lineHeight) { lineHeight(it) }
    )
}