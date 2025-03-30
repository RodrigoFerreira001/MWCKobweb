package com.catbit.mwckobweb.components.ripple

import androidx.compose.runtime.Composable
import com.catbit.mwckobweb.foundation.modifiers.thenIf
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.dom.Div

@Composable
fun RippleContainer(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    Div(
        attrs = modifier
            .styleModifier {
                property("position", "relative")
            }
            .thenIf(enabled) {
                onClick { onClick() }.cursor(Cursor.Pointer)
            }
            .toAttrs()
    ) {
        Ripple(enabled = enabled)

        content()
    }
}