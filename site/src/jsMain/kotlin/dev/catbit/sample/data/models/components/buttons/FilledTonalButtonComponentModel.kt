package dev.catbit.sample.data.models.components.buttons

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object FilledTonalButtonComponentModel : ComponentModel {
    override val identifier = "filled-tonal-button"
    override val searchTerms = listOf("button", "tonal", "filled")
    override val title = "FilledTonalButton"
    override val description = "Filled tonal buttons are used for secondary actions that require more emphasis than a text or outlined button, but less emphasis than a filled button."
    override val briefDescription = "A filled tonal button for medium emphasis actions."
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
            name = "containerColor",
            type = "CSSColorValue",
            optional = false,
            defaultValue = "MaterialTheme.colorScheme.secondaryContainer",
            description = ""
        ),
        ComponentParam(
            name = "contentColor",
            type = "CSSColorValue",
            optional = false,
            defaultValue = "MaterialTheme.colorScheme.onSecondaryContainer",
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