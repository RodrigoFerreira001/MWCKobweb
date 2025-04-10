package dev.catbit.sample.data.models.components.chip

import androidx.compose.runtime.Composable
import dev.catbit.sample.data.models.components.ComponentModel
import dev.catbit.sample.data.models.components.ComponentParam

object FilterChipComponentModel : ComponentModel {
    override val identifier = "filter-chip"
    override val searchTerms = listOf("chip", "filter", "removable", "selectable", "icon")
    override val title = "FilterChip"
    override val description = "A chip that allows users to select or deselect options. It can also be removable and include an icon."
    override val briefDescription = "A selectable chip used for filtering content with optional remove and icon support."
    override val image = ""
    override val codeExample = ""
    override val params = listOf(
        ComponentParam(
            name = "modifier",
            type = "Modifier",
            optional = true,
            defaultValue = "Modifier",
            description = "Modifier used to adjust layout or styling of the chip."
        ),
        ComponentParam(
            name = "label",
            type = "String",
            optional = false,
            defaultValue = null,
            description = "Text label displayed inside the chip."
        ),
        ComponentParam(
            name = "onClick",
            type = "() -> Unit",
            optional = false,
            defaultValue = null,
            description = "Callback triggered when the chip is clicked."
        ),
        ComponentParam(
            name = "onRemove",
            type = "() -> Unit?",
            optional = true,
            defaultValue = "null",
            description = "Optional callback triggered when the chip is removed."
        ),
        ComponentParam(
            name = "enabled",
            type = "Boolean",
            optional = true,
            defaultValue = "true",
            description = "Controls whether the chip is interactive."
        ),
        ComponentParam(
            name = "removable",
            type = "Boolean",
            optional = true,
            defaultValue = "false",
            description = "Controls whether the chip can be removed."
        ),
        ComponentParam(
            name = "selected",
            type = "Boolean",
            optional = true,
            defaultValue = "false",
            description = "Controls the selected state of the chip."
        ),
        ComponentParam(
            name = "selectedContainerColor",
            type = "CSSColorValue",
            optional = true,
            defaultValue = "MaterialTheme.colorScheme.secondaryContainer",
            description = "Container color when the chip is selected."
        ),
        ComponentParam(
            name = "outlineColor",
            type = "CSSColorValue",
            optional = true,
            defaultValue = "MaterialTheme.colorScheme.outline",
            description = "Outline color of the chip border."
        ),
        ComponentParam(
            name = "contentColor",
            type = "CSSColorValue",
            optional = true,
            defaultValue = "MaterialTheme.colorScheme.onSurface",
            description = "Color of the label text and icon."
        ),
        ComponentParam(
            name = "iconSize",
            type = "CSSLengthOrPercentageNumericValue",
            optional = true,
            defaultValue = "18.px",
            description = "Size of the optional icon in the chip."
        ),
        ComponentParam(
            name = "shape",
            type = "CSSLengthOrPercentageNumericValue",
            optional = true,
            defaultValue = "MaterialTheme.shape.small",
            description = "Shape of the chip container."
        ),
        ComponentParam(
            name = "font",
            type = "FontFamily?",
            optional = true,
            defaultValue = "MaterialTheme.typography.labelLarge.fontFamily",
            description = "Font used for the label text."
        ),
        ComponentParam(
            name = "icon",
            type = "(@Composable () -> Unit)?",
            optional = true,
            defaultValue = "null",
            description = "Optional composable icon displayed before the label."
        )
    )
    override val composableExample = @Composable {}
}