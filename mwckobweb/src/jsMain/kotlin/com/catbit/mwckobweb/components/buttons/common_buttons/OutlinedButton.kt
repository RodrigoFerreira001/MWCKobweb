package com.catbit.mwckobweb.components.buttons.common_buttons

import androidx.compose.runtime.Composable
import com.catbit.mwckobweb.components.buttons.common_buttons.BaseButton
import com.catbit.mwckobweb.foundation.text.FontFamily
import com.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.foundation.layout.RowScope
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSColorValue

@Composable
fun OutlinedButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    enabled: Boolean = true,
    outlineColor: CSSColorValue = MaterialTheme.colorScheme.outline,
    contentColor: CSSColorValue = MaterialTheme.colorScheme.primary,
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.full,
    font: FontFamily? = MaterialTheme.typography.labelLarge.fontFamily,
    content: @Composable RowScope.() -> Unit
) {
    BaseButton(
        modifier = modifier.styleModifier {
            property("--md-outlined-button-outline-color", outlineColor)
            property("--md-outlined-button-container-shape", shape)
            property("--md-outlined-button-label-text-color", contentColor)
            font?.let { property("--md-outlined-button-label-text-font", font.name) }
        },
        onClick = onClick,
        buttonStyle = "md-outlined-button",
        enabled = enabled,
        content = content
    )
}