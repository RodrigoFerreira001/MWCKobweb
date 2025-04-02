package dev.catbit.mwckobweb.components.ripple

import androidx.compose.runtime.Composable
import dev.catbit.mwckobweb.foundation.modifiers.thenIf
import dev.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.onClick
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.dom.Div

@Composable
fun RippleContainer(
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    hoverColor: CSSColorValue = MaterialTheme.colorScheme.onSurface,
    pressedColor: CSSColorValue = MaterialTheme.colorScheme.onSurface,
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
        Ripple(
            enabled = enabled,
            hoverColor = hoverColor,
            pressedColor = pressedColor,
        )
        content()
    }
}