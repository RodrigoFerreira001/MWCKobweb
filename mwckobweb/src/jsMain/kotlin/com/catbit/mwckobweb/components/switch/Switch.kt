package com.catbit.mwckobweb.components.switch

import androidx.compose.runtime.Composable
import com.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue

@Composable
fun Switch(
    modifier: Modifier = Modifier,
    selected: Boolean,
    onChange: (Boolean) -> Unit,
    enabled: Boolean = true,
    showOnlySelectedIcon: Boolean = false,
    showBothIcons: Boolean = false,
    handleColor: CSSColorValue = MaterialTheme.colorScheme.outline,
    selectedHandleColor: CSSColorValue = MaterialTheme.colorScheme.onPrimary,
    handleShape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.full,
    trackColor: CSSColorValue = MaterialTheme.colorScheme.surfaceContainerHighest,
    selectedTrackColor: CSSColorValue = MaterialTheme.colorScheme.primary,
    trackShape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.full,
) {
    GenericTag(
        name = "md-switch",
        attrs = modifier.toAttrs {
            if (selected) attr("selected", "")
            if (!enabled) attr("disabled", "")
            if (!showOnlySelectedIcon) attr("show-only-selected-icon", "")
            if (!showBothIcons) attr("icons", "")

            style {
                property("--md-switch-handle-color", handleColor)
                property("--md-switch-handle-shape", handleShape)
                property("--md-switch-track-color", trackColor)
                property("--md-switch-track-shape", trackShape)
                property("--md-switch-selected-handle-color", selectedHandleColor)
                property("--md-switch-selected-track-color", selectedTrackColor)
            }
            ref { element ->
                element.addEventListener("change", { onChange(!selected) })
                onDispose { }
            }
        }
    )
}