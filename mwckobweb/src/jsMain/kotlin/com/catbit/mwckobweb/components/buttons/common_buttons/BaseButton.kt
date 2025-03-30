package com.catbit.mwckobweb.components.buttons.common_buttons

import androidx.compose.runtime.Composable
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.foundation.layout.Row
import com.varabyte.kobweb.compose.foundation.layout.RowScope
import com.varabyte.kobweb.compose.ui.Alignment
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.attr
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.maxHeight
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px

@Composable
internal fun BaseButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonStyle: String,
    enabled: Boolean = true,
    content: @Composable RowScope.() -> Unit
) {
    GenericTag(
        name = buttonStyle,
        attrs = modifier
            .cursor(Cursor.Pointer)
            .maxHeight(40.px)
            .toAttrs {
                if (!enabled) { attr("disabled", "") }
                ref { element ->
                    element.addEventListener("click", { onClick() })
                    onDispose { }
                }
            }
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            content()
        }
    }
}

fun Modifier.iconSlot() = attr("slot", "icon")