package dev.catbit.sample.data.models.components.buttons

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object TextButtonComponentModel : ComponentModel {
    override val identifier = "text-button"
    override val searchTerms = listOf("button", "text")
    override val title = "TextButton"
    override val description = "Text buttons are typically used for less-pronounced actions, including those located in dialogs and cards."
    override val briefDescription = "A low-emphasis button used for less prominent actions."
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
            name = "contentColor",
            type = "CSSColorValue",
            optional = false,
            defaultValue = "MaterialTheme.colorScheme.primary",
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