package com.catbit.mwckobweb.components.ripple

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs

@Composable
fun Ripple(
    enabled: Boolean = true,
) {
    GenericTag(
        name = "md-ripple",
        attrs = Modifier.toAttrs {
            if (!enabled) {
                attr("disabled", "")
            }
        }
    )
}
