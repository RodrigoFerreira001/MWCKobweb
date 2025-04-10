package dev.catbit.sample.data.models.components.buttons.icon_buttons

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object OutlinedIconButtonComponentModel : ComponentModel {
    override val identifier = "outlined-icon-button"
    override val searchTerms = listOf("icon", "button", "outlined", "iconbutton")
    override val title = "OutlinedIconButton"
    override val description = "An icon button with an outline border, ideal for medium-emphasis actions."
    override val briefDescription = "Outlined icon button with customizable border and icon."
    override val image = ""
    override val codeExample = ""
    override val params = listOf(
        ComponentParam(
            name = "modifier",
            type = "Modifier",
            optional = true,
            defaultValue = "Modifier",
            description = "Modifier to adjust the layout or styling."
        ),
        ComponentParam(
            name = "onClick",
            type = "() -> Unit",
            optional = false,
            defaultValue = null,
            description = "Callback triggered when the icon button is clicked."
        ),
        ComponentParam(
            name = "enabled",
            type = "Boolean",
            optional = true,
            defaultValue = "true",
            description = "Controls whether the button is enabled."
        ),
        ComponentParam(
            name = "selected",
            type = "Boolean",
            optional = true,
            defaultValue = "false",
            description = "Indicates whether the icon button is selected."
        ),
        ComponentParam(
            name = "outlineColor",
            type = "CSSColorValue",
            optional = true,
            defaultValue = "MaterialTheme.colorScheme.outline",
            description = "Color of the outline border."
        ),
        ComponentParam(
            name = "outlineWidth",
            type = "CSSLengthOrPercentageNumericValue",
            optional = true,
            defaultValue = "1.px",
            description = "Width of the outline border."
        ),
        ComponentParam(
            name = "shape",
            type = "CSSLengthOrPercentageNumericValue",
            optional = true,
            defaultValue = "MaterialTheme.shape.full",
            description = "Shape of the button's container."
        ),
        ComponentParam(
            name = "iconSize",
            type = "CSSLengthOrPercentageNumericValue",
            optional = true,
            defaultValue = "24.px",
            description = "Size of the icon."
        ),
        ComponentParam(
            name = "content",
            type = "@Composable () -> Unit",
            optional = false,
            defaultValue = null,
            description = "Composable content, typically an icon."
        )
    )
    override val composableExample = @Composable {}
}