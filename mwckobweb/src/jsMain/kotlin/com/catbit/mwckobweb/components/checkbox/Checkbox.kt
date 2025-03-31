package com.catbit.mwckobweb.components.checkbox

import androidx.compose.runtime.Composable
import com.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue

@Composable
fun Checkbox(
    modifier: Modifier = Modifier,
    checked: Boolean,
    indeterminate: Boolean = false,
    onCheckChange: (Boolean) -> Unit,
    enabled: Boolean = true,
    outlineColor: CSSColorValue = MaterialTheme.colorScheme.onSurfaceVariant,
    selectedContainerColor: CSSColorValue = MaterialTheme.colorScheme.primary,
    selectedIconColor: CSSColorValue = MaterialTheme.colorScheme.onPrimary
) {
    GenericTag(
        name = "md-checkbox",
        attrs = modifier.toAttrs {
            if (checked) attr("checked", "")
            if (indeterminate) attr("indeterminate", "")
            if (!enabled) attr("disabled", "")

            style {
                property("--md-checkbox-outline-color", outlineColor)
                property("--md-checkbox-selected-container-color", selectedContainerColor)
                property("--md-checkbox-selected-icon-color", selectedIconColor)
            }
            ref { element ->
                element.addEventListener("change", { onCheckChange(!checked) })
                onDispose { }
            }
        }
    )
}