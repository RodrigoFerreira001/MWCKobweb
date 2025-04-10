package dev.catbit.sample.data.models.components.buttons.icon_buttons

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object IconButtonComponentModel : ComponentModel {
    override val identifier = "icon-button"
    override val searchTerms = listOf("icon", "button", "iconbutton")
    override val title = "IconButton"
    override val description = "A standard icon button used to represent actions with an icon."
    override val briefDescription = "Standard icon button with support for selection and custom color."
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
            name = "iconColor",
            type = "CSSColorValue",
            optional = true,
            defaultValue = "MaterialTheme.colorScheme.onSurfaceVariant",
            description = "Color of the icon inside the button."
        ),
        ComponentParam(
            name = "shape",
            type = "CSSLengthOrPercentageNumericValue",
            optional = true,
            defaultValue = "MaterialTheme.shape.full",
            description = "Shape of the button's state layer."
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