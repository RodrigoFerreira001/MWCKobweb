package dev.catbit.mwckobweb.components.chip

import androidx.compose.runtime.Composable
import dev.catbit.mwckobweb.foundation.text.FontFamily
import dev.catbit.mwckobweb.foundation.theme.MaterialTheme
import com.varabyte.kobweb.compose.css.CSSLengthOrPercentageNumericValue
import com.varabyte.kobweb.compose.ui.Modifier
import com.varabyte.kobweb.compose.ui.attrsModifier
import com.varabyte.kobweb.compose.ui.styleModifier
import org.jetbrains.compose.web.css.CSSColorValue
import org.jetbrains.compose.web.css.px

@Composable
fun FilterChip(
    modifier: Modifier = Modifier,
    label: String,
    onClick: () -> Unit,
    onRemove: (() -> Unit)? = null,
    enabled: Boolean = true,
    removable: Boolean = false,
    selected: Boolean = false,
    selectedContainerColor: CSSColorValue = MaterialTheme.colorScheme.secondaryContainer,
    outlineColor: CSSColorValue = MaterialTheme.colorScheme.outline,
    contentColor: CSSColorValue = MaterialTheme.colorScheme.onSurface,
    iconSize: CSSLengthOrPercentageNumericValue = 18.px,
    shape: CSSLengthOrPercentageNumericValue = MaterialTheme.shape.small,
    font: FontFamily? = MaterialTheme.typography.labelLarge.fontFamily,
    icon: (@Composable () -> Unit)? = null
) {
    BaseChip(
        modifier = modifier
            .styleModifier {
                property("--md-filter-chip-selected-container-color", selectedContainerColor)
                property("--md-filter-chip-outline-color", outlineColor)
                property("--md-filter-chip-container-shape", shape)
                property("--md-filter-chip-icon-size", iconSize)
                property("--md-filter-chip-label-text-color", contentColor)
                font?.let { property("--md-filter-chip-label-text-font", font.name) }
            }
            .attrsModifier {
                if (selected) attr("selected", "")
                if (removable) attr("removable", "")
                if (icon != null) attr("has-icon", "")
            },
        label = label,
        onClick = onClick,
        iconSize = iconSize,
        onRemove = onRemove,
        chipStyle = "md-filter-chip",
        enabled = enabled,
        icon = icon
    )
}