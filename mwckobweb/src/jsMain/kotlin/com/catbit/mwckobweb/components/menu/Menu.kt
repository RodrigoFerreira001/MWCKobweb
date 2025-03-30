package com.catbit.mwckobweb.components.menu

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs

@Composable
fun Menu(
    modifier: Modifier = Modifier,
    anchor: String,
    open: Boolean,
    quick: Boolean = false,
    onClose: () -> Unit,
    content: @Composable () -> Unit
) {
    GenericTag(
        name = "md-menu",
        attrs = modifier.toAttrs {
            attr("anchor", anchor)
            if (open) attr("open", "")
            if (quick) attr("quick", "")

            ref { element ->
                element.addEventListener("closed", { onClose() })
                onDispose { }
            }
        }
    ) {
        content()
    }
}