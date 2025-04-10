package dev.catbit.sample.data.models.components.buttons

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object FilledButtonComponentModel : ComponentModel {
    override val identifier = "filled-button"
    override val searchTerms = listOf("button", "filled")
    override val title = "FilledButton"
    override val description = "The filled button’s contrasting surface color makes it the most prominent button after the FAB. It’s used for final or unblocking actions in a flow."
    override val briefDescription = "The filled button’s contrasting surface color makes it the most prominent button after the FAB. It’s used for final or unblocking actions in a flow."
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
            defaultValue = "MaterialTheme.colorScheme.primary",
            description = ""
        ),
        ComponentParam(
            name = "contentColor",
            type = "CSSColorValue",
            optional = false,
            defaultValue = "MaterialTheme.colorScheme.onPrimary",
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