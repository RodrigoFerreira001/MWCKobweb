package dev.catbit.sample.data.models.components.buttons

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object OutlinedButtonComponentModel : ComponentModel {
    override val identifier = "outlined-button"
    override val searchTerms = listOf("button", "outlined")
    override val title = "OutlinedButton"
    override val description = "Outlined buttons are medium-emphasis buttons. They contain actions that are important but aren’t the primary action in an app."
    override val briefDescription = "An outlined button used for medium emphasis actions."
    override val image = ""
    override val codeExample = ""
    override val params = listOf(
        ComponentParam(
            name = "onClick",
            type = "() -> Unit",
            optional = false,
            defaultValue = null,
            description = ""
        ),
        ComponentParam(
            name = "enabled",
            type = "Boolean",
            optional = false,
            defaultValue = "true",
            description = ""
        ),
        ComponentParam(
            name = "outlineColor",
            type = "CSSColorValue",
            optional = false,
            defaultValue = "MaterialTheme.colorScheme.outline",
            description = ""
        ),
        ComponentParam(
            name = "contentColor",
            type = "CSSColorValue",
            optional = false,
            defaultValue = "MaterialTheme.colorScheme.primary",
            description = ""
        ),
        ComponentParam(
            name = "shape",
            type = "CSSLengthOrPercentageNumericValue",
            optional = false,
            defaultValue = "MaterialTheme.shape.full",
            description = ""
        ),
        ComponentParam(
            name = "font",
            type = "FontFamily",
            optional = true,
            defaultValue = "MaterialTheme.typography.labelLarge.fontFamily",
            description = ""
        ),
        ComponentParam(
            name = "content",
            type = "@Composable RowScope.() -> Unit",
            optional = false,
            defaultValue = null,
            description = ""
        )
    )
    override val composableExample = @Composable {}
}