package dev.catbit.sample.data.models.components.app_bars.top_app_bars

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object SmallTopAppBarComponentModel : ComponentModel {
    override val identifier = "small-top-app-bar"
    override val searchTerms = listOf("app bar", "top app bar", "small", "navigation", "toolbar")
    override val title = "SmallTopAppBar"
    override val description = "A compact top app bar suitable for screens with minimal vertical space, featuring a title, navigation icon, and optional action icons."
    override val briefDescription = "Compact top app bar with title, navigation icon, and optional actions."
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