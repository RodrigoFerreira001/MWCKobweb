package com.catbit.mwckobweb.components.buttons.icon_button

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import com.catbit.mwckobweb.foundation.locals.LocalIconSize
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.css.Cursor
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.modifiers.cursor
import com.varabyte.kobweb.compose.ui.modifiers.minSize
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.px

@Composable
internal fun BaseIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    buttonStyle: String,
    enabled: Boolean = true,
    selected: Boolean = false,
    iconSize: CSSLengthOrPercentageNumericValue = 24.px,
    content: @Composable () -> Unit,
) {
    GenericTag(
        name = buttonStyle,
        attrs = modifier
            .cursor(Cursor.Pointer)
            .minSize(48.px)
            .toAttrs {
                if (!enabled) {
                    attr("disabled", "")
                }
                if (selected) {
                    attr("selected", "")
                }
                ref { element ->
                    element.addEventListener("click", { onClick() })
                    onDispose { }
                }
            }
    ) {
        CompositionLocalProvider(
            LocalIconSize provides iconSize
        ) {
            content()
        }
    }
}