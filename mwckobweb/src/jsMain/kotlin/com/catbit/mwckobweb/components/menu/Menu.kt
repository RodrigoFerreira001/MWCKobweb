package com.catbit.mwckobweb.components.menu

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px

@Composable
fun Menu(
    modifier: Modifier = Modifier,
    anchor: String,
    open: Boolean,
    quick: Boolean = false,
    onClose: () -> Unit,
    xOffset: CSSLengthOrPercentageNumericValue = 0.px,
    yOffset: CSSLengthOrPercentageNumericValue = 0.px,
    content: @Composable () -> Unit
) {
    GenericTag(
        name = "md-menu",
        attrs = modifier.toAttrs {
            attr("anchor", anchor)
            attr("x-offset", xOffset.toString())
            attr("y-offset", yOffset.toString())
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