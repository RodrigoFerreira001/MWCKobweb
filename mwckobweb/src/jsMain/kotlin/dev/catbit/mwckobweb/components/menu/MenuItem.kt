package dev.catbit.mwckobweb.components.menu

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs

@Composable
fun MenuItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    content: @Composable () -> Unit
) {
    GenericTag(
        name = "md-menu-item",
        attrs = modifier.toAttrs {
            ref { element ->
                element.addEventListener("click", { onClick() })
                onDispose { }
            }
        }
    ) {
        content()
    }
}