package dev.catbit.sample.data.models.components.checkbox

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object CheckboxComponentModel : ComponentModel {
    override val identifier = "checkbox"
    override val searchTerms = listOf("checkbox", "toggle", "check", "input")
    override val title = "Checkbox"
    override val description = "A Material Design checkbox that allows users to select one or multiple items from a set."
    override val briefDescription = "Checkbox for multiple selection or toggle input."
    override val image = ""
    override val codeExample = ""
    override val params = listOf(
        ComponentParam(
            name = "modifier",
            type = "Modifier",
            optional = true,
            defaultValue = "Modifier",
            description = "Modifier used to adjust the layout or styling of the checkbox."
        ),
        ComponentParam(
            name = "checked",
            type = "Boolean",
            optional = false,
            defaultValue = null,
            description = "Controls whether the checkbox is checked."
        ),
        ComponentParam(
            name = "indeterminate",
            type = "Boolean",
            optional = true,
            defaultValue = "false",
            description = "If true, shows an indeterminate visual state (typically a dash)."
        ),
        ComponentParam(
            name = "onCheckChange",
            type = "(Boolean) -> Unit",
            optional = false,
            defaultValue = null,
            description = "Callback triggered when the checkbox is toggled."
        ),
        ComponentParam(
            name = "enabled",
            type = "Boolean",
            optional = true,
            defaultValue = "true",
            description = "Controls whether the checkbox is enabled for interaction."
        ),
        ComponentParam(
            name = "outlineColor",
            type = "CSSColorValue",
            optional = true,
            defaultValue = "MaterialTheme.colorScheme.onSurfaceVariant",
            description = "Color of the checkbox outline when not selected."
        ),
        ComponentParam(
            name = "selectedContainerColor",
            type = "CSSColorValue",
            optional = true,
            defaultValue = "MaterialTheme.colorScheme.primary",
            description = "Color of the checkbox container when selected."
        ),
        ComponentParam(
            name = "selectedIconColor",
            type = "CSSColorValue",
            optional = true,
            defaultValue = "MaterialTheme.colorScheme.onPrimary",
            description = "Color of the checkmark or dash icon when selected."
        )
    )
    override val composableExample = @Composable {}
}