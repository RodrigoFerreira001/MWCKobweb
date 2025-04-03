package dev.catbit.kobwebmaterial.components.ripple

import androidx.compose.runtime.Composable
import dev.catbit.kobwebmaterial.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue

@Composable
fun Ripple(
    hoverColor: CSSColorValue = MaterialTheme.colorScheme.onSurface,
    pressedColor: CSSColorValue = MaterialTheme.colorScheme.onSurface,
    enabled: Boolean = true,
) {
    GenericTag(
        name = "md-ripple",
        attrs = Modifier
            .styleModifier {
                property("--md-ripple-hover-color", hoverColor)
                property("--md-ripple-pressed-color", pressedColor)
            }
            .toAttrs {
                if (!enabled) { attr("disabled", "") }
            }
    )
}
