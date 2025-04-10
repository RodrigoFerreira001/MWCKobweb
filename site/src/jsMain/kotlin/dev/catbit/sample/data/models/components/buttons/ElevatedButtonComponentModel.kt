package dev.catbit.sample.data.models.components.buttons

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object ElevatedButtonComponentModel : ComponentModel {
    override val identifier = "elevated-button"
    override val searchTerms = listOf("button", "elevated")
    override val title = "ElevatedButton"
    override val description = "Elevated buttons are used for emphasis in layouts with lots of elements or when a subtle elevation helps draw attention without being too prominent."
    override val briefDescription = "Elevated buttons provide subtle elevation for low emphasis actions."
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
            defaultValue = "MaterialTheme.colorScheme.surface",
            description = ""
        ),
        ComponentParam(
            name = "contentColor",
            type = "CSSColorValue",
            optional = false,
            defaultValue = "MaterialTheme.colorScheme.onSurface",
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