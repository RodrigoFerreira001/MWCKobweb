package com.catbit.mwckobweb.components.buttons.icon_button

import androidx.compose.runtime.Composable
import com.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.px

@Composable
fun OutlinedIconButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    selected: Boolean = false,
    outlineColor: CSSColorValue = MaterialTheme.colorScheme.outline,
    outlineWidth: CSSLengthOrPercentageNumericValue = 1.px,
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.full,
    iconSize: CSSLengthOrPercentageNumericValue = 24.px,
    content: @Composable () -> Unit
) {
    BaseIconButton(
        modifier = modifier.styleModifier {
            property("--md-outlined-icon-button-outline-color", outlineColor)
            property("--md-outlined-icon-button-outline-width", outlineWidth)
            property("--md-outlined-icon-button-container-shape", shape)
            property("--md-outlined-icon-button-icon-size", iconSize)
        },
        onClick = onClick,
        buttonStyle = "md-outlined-icon-button",
        enabled = enabled,
        selected = selected,
        content = content,
        iconSize = iconSize,
    )
}