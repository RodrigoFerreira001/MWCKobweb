package dev.catbit.sample.data.models.components.buttons.floating_action_button

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object FloatingActionButtonComponentModel : ComponentModel {
    override val identifier = "floating-action-button"
    override val searchTerms = listOf("fab", "button", "floating", "action", "icon", "primary")
    override val title = "FloatingActionButton"
    override val description = "A circular button that floats above content to promote a primary action in the application."
    override val briefDescription = "FAB used for primary or emphasized actions."
    override val image = ""
    override val codeExample = ""
    override val params = listOf(
        ComponentParam(
            name = "modifier",
            type = "Modifier",
            optional = true,
            defaultValue = "Modifier",
            description = "Modifier used to adjust the layout or styling of the FAB."
        ),
        ComponentParam(
            name = "onClick",
            type = "() -> Unit",
            optional = false,
            defaultValue = null,
            description = "Callback triggered when the FAB is clicked."
        ),
        ComponentParam(
            name = "enabled",
            type = "Boolean",
            optional = true,
            defaultValue = "true",
            description = "Controls whether the FAB is enabled or disabled."
        ),
        ComponentParam(
            name = "label",
            type = "String?",
            optional = true,
            defaultValue = "null",
            description = "Optional text label for accessibility or extended FAB variants."
        ),
        ComponentParam(
            name = "variant",
            type = "FloatingActionButtonVariant",
            optional = true,
            defaultValue = "FloatingActionButtonVariant.Primary",
            description = "Defines the visual variant of the FAB: Primary, Secondary, or Tertiary."
        ),
        ComponentParam(
            name = "size",
            type = "FloatingActionButtonSize",
            optional = true,
            defaultValue = "FloatingActionButtonSize.Medium",
            description = "Controls the overall size of the FAB: Small, Medium, or Large."
        ),
        ComponentParam(
            name = "containerShape",
            type = "CSSLengthOrPercentageNumericValue",
            optional = true,
            defaultValue = "MaterialTheme.shape.large",
            description = "Defines the shape of the FAB container."
        ),
        ComponentParam(
            name = "containerColor",
            type = "CSSColorValue",
            optional = true,
            defaultValue = "MaterialTheme.colorScheme.surfaceContainerHigh",
            description = "Background color of the FAB in normal state."
        ),
        ComponentParam(
            name = "containerLoweredColor",
            type = "CSSColorValue",
            optional = true,
            defaultValue = "MaterialTheme.colorScheme.surfaceContainerLow",
            description = "Background color of the FAB when in a lowered state."
        ),
        ComponentParam(
            name = "contentColor",
            type = "CSSColorValue",
            optional = true,
            defaultValue = "MaterialTheme.colorScheme.primary",
            description = "Color of the icon or content inside the FAB."
        ),
        ComponentParam(
            name = "lowered",
            type = "Boolean",
            optional = true,
            defaultValue = "false",
            description = "Indicates whether the FAB appears in a lowered state (closer to the background)."
        ),
        ComponentParam(
            name = "content",
            type = "(@Composable () -> Unit)?",
            optional = true,
            defaultValue = "null",
            description = "Optional composable content, usually an icon, displayed inside the FAB."
        )
    )
    override val composableExample = @Composable {}
}