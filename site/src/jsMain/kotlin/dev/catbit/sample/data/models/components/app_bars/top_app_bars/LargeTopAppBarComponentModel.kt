package dev.catbit.sample.data.models.components.app_bars.top_app_bars

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object LargeTopAppBarComponentModel : ComponentModel {
    override val identifier = "large-top-app-bar"
    override val searchTerms = listOf("app bar", "top app bar", "large", "navigation", "toolbar")
    override val title = "LargeTopAppBar"
    override val description = "A top app bar that provides a larger space for the title and additional content, typically used at the top of full-screen layouts."
    override val briefDescription = "Large top app bar with prominent title and optional navigation and actions."
    override val image = ""
    override val codeExample = ""
    override val params = listOf(
        ComponentParam(
            name = "modifier",
            type = "Modifier",
            optional = true,
            defaultValue = "Modifier",
            description = "Modifier used to adjust the layout or styling of the top app bar."
        ),
        ComponentParam(
            name = "title",
            type = "@Composable () -> Unit",
            optional = false,
            defaultValue = null,
            description = "Composable lambda to display the title content, typically text."
        ),
        ComponentParam(
            name = "navigationIcon",
            type = "@Composable () -> Unit",
            optional = false,
            defaultValue = null,
            description = "Composable lambda to provide a navigation icon, such as a back or menu button."
        ),
        ComponentParam(
            name = "actions",
            type = "(@Composable RowScope.() -> Unit)?",
            optional = true,
            defaultValue = "null",
            description = "Optional composable lambda to provide action icons or buttons aligned to the end of the app bar."
        ),
        ComponentParam(
            name = "colors",
            type = "TopAppBarColors",
            optional = true,
            defaultValue = "TopAppBarColors.Default()",
            description = "Defines custom colors for the app bar's container, navigation icon, title, and action icons."
        )
    )
    override val composableExample = @Composable {}
}