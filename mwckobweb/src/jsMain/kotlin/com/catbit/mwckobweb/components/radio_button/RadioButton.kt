package com.catbit.mwckobweb.components.radio_button

import androidx.compose.runtime.Composable
import com.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.dom.GenericTag
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.toAttrs
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.CSSSizeValue
import org.jetbrains.compose.web.css.CSSUnit
import org.jetbrains.compose.web.css.px

@Composable
fun RadioButton(
    modifier: Modifier = Modifier,
    value: String,
    selected: Boolean,
    onSelect: (String) -> Unit,
    groupName: String? = null,
    enabled: Boolean = true,
    iconColor: CSSColorValue = MaterialTheme.colorScheme.onSurfaceVariant,
    selectedIconColor: CSSColorValue = MaterialTheme.colorScheme.primary,
    iconSize: CSSSizeValue<CSSUnit.px> = 20.px,
) {
    GenericTag(
        name = "md-radio",
        attrs = modifier.toAttrs {
            if (selected) attr("checked", "")
            if (!enabled) attr("disabled", "")
            groupName?.let { attr("name", it) }
            attr("value", value)
            style {
                property("--md-radio-icon-color", iconColor)
                property("--md-radio-selected-icon-color", selectedIconColor)
                property("--md-radio-icon-size", iconSize.toString())
            }
            ref { element ->
                element.addEventListener("change", { onSelect(value) })
                onDispose { }
            }
        }
    )
}