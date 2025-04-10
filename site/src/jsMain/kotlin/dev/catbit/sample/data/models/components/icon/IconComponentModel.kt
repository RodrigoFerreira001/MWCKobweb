package dev.catbit.sample.data.models.components.icon

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object IconComponentModel : ComponentModel {
    override val identifier = "icon"
    override val searchTerms = listOf("icon", "material", "symbol", "image", "visual")
    override val title = "Icon"
    override val description = "A composable that renders a Material Symbol icon with full control over style, weight, grade, and optical size."
    override val briefDescription = "Composable Material Symbol icon with customizable style and weight."
    override val image = ""
    override val codeExample = ""
    override val params = listOf(
        ComponentParam(
            name = "name",
            type = "String",
            optional = false,
            defaultValue = null,
            description = "The name of the Material Symbol to render."
        ),
        ComponentParam(
            name = "modifier",
            type = "Modifier",
            optional = true,
            defaultValue = "Modifier",
            description = "Modifier to adjust layout, size, or style."
        ),
        ComponentParam(
            name = "style",
            type = "SymbolStyle",
            optional = true,
            defaultValue = "SymbolStyle.Rounded",
            description = "The visual style of the icon: Outlined, Rounded, or Sharp."
        ),
        ComponentParam(
            name = "weight",
            type = "SymbolWeight",
            optional = true,
            defaultValue = "SymbolWeight.Normal",
            description = "The weight (thickness) of the icon: from Thin to Bold."
        ),
        ComponentParam(
            name = "grade",
            type = "SymbolGrade",
            optional = true,
            defaultValue = "SymbolGrade.Normal",
            description = "The grade (emphasis) of the icon: Low, Normal, or HighEmphasis."
        ),
        ComponentParam(
            name = "opticalSize",
            type = "SymbolOpticalSize",
            optional = true,
            defaultValue = "SymbolOpticalSize.Size24",
            description = "The optical size (size variant) of the icon: 20, 24, 40, or 48."
        ),
        ComponentParam(
            name = "tint",
            type = "CSSColorValue?",
            optional = true,
            defaultValue = "null",
            description = "Optional tint color for the icon."
        ),
        ComponentParam(
            name = "fill",
            type = "Boolean",
            optional = true,
            defaultValue = "false",
            description = "Whether the icon is filled (true) or outlined (false)."
        )
    )
    override val composableExample = @Composable {}
}